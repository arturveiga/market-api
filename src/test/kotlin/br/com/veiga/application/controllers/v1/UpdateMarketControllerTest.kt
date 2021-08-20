package br.com.veiga.application.controllers.v1

import br.com.veiga.application.controllers.v1.request.UpdateMarketRequest
import br.com.veiga.core.services.UpdateMarketService
import br.com.veiga.mocks.MarketMock
import com.fasterxml.jackson.databind.ObjectMapper
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@WebMvcTest(controllers = [UpdateMarketController::class])
@AutoConfigureMockMvc
internal class UpdateMarketControllerTest {
    @Autowired
    lateinit var mvc: MockMvc

    @MockBean
    lateinit var updateMarketService: UpdateMarketService

    @Test
    fun `update a market`() {
        val updateMarketRequest = UpdateMarketRequest(
            longitude = -1.203203,
            latitude = 2.3213213,
            sector = "sector updated",
            area = "area",
            districtCode = "1230",
            districtName = "Sao luis",
            subCityHallCode = 1,
            subCityHallName = "Cohama",
            region05 = "West",
            region08 = "North",
            name = "Market XP",
            register = "7210-9",
            street = "RUA JOSE MARTINS DOS SANTOS",
            number = "s/n",
            neighborhood = "VL FORMOSA",
            reference = "TV RUA PRETORIA"
        )

        val json = ObjectMapper().writeValueAsString(updateMarketRequest)

        BDDMockito.given(updateMarketService.execute(any(), any())).willReturn(MarketMock.marketUpdate)

        val request = put("/v1/markets/{id}", 1)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(json)

        mvc.perform(request)
            .andExpect(status().isOk)
            .andExpect(jsonPath("name").value(updateMarketRequest.name))
    }
}