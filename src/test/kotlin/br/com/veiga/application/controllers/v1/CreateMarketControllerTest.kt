package br.com.veiga.application.controllers.v1

import br.com.veiga.application.controllers.v1.request.extensions.toModel
import br.com.veiga.core.services.CreateMarketService
import br.com.veiga.mocks.MarketMock
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@WebMvcTest(controllers = [CreateMarketController::class])
@AutoConfigureMockMvc
internal class CreateMarketControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var service: CreateMarketService

    companion object {
        const val URL_BASE = "/v1/markets"
    }

    @Test
    fun `create a market`() {
        val createMarketRequest = MarketMock.createMarketRequest
        val marketResponse = MarketMock.marketResponse

        BDDMockito.given(service.execute(createMarketRequest.toModel())).willReturn(MarketMock.market)
        val json = ObjectMapper().writeValueAsString(createMarketRequest)

        val request = post(URL_BASE)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(json)

        mvc
            .perform(request)
            .andExpect(status().isCreated)
            .andExpect(jsonPath("latitude").value(marketResponse.latitude))
            .andExpect(jsonPath("subCityHallCode").value(marketResponse.subCityHallCode))
    }
}