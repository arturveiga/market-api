package br.com.veiga.application.controllers.v1

import br.com.veiga.core.exceptions.MarketNotFoundException
import br.com.veiga.core.services.SearchMarketService
import br.com.veiga.mocks.MarketMock
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.kotlin.any
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@WebMvcTest(controllers = [SearchMarketController::class])
@AutoConfigureMockMvc
internal class SearchMarketControllerTest {
    @Autowired
    lateinit var mvc: MockMvc

    @MockBean
    lateinit var searchMarketService: SearchMarketService

    companion object {
        const val URL_BASE = "/v1/markets"
    }

    @Test
    fun `find markets`() {
        val marketsMock = listOf(
            MarketMock.market,
            MarketMock.market.copy(
                id = 2,
                name = "Market2"
            ),
            MarketMock.market.copy(
                id = 3,
                name = "Market3"
            )
        )

        BDDMockito.given(searchMarketService.execute(any(), any(), any())).willReturn(marketsMock)

        val request = get(URL_BASE)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)

        mvc.perform(request)
            .andExpect(status().isOk)
            .andExpect(jsonPath("content").isArray)

    }

    @Test
    fun `find by id`() {
        BDDMockito.given(searchMarketService.execute(any())).willReturn(MarketMock.market)

        val request = get("$URL_BASE/{id}", 1)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)

        mvc.perform(request)
            .andExpect(status().isOk)
            .andExpect(jsonPath("id").isNumber)
            .andExpect(jsonPath("name").isString)
            .andExpect(jsonPath("districtName").isString)
    }

    @Test
    fun `when id is not found`() {
        BDDMockito.given(searchMarketService.execute(any())).willThrow(MarketNotFoundException::class.java)

        val request = get("$URL_BASE/{id}", 1)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)

        mvc.perform(request)
            .andExpect(status().isNotFound)
    }

}