package br.com.veiga.application.controllers.v1

import br.com.veiga.application.controllers.v1.CreateMarketControllerTest.Companion.URL_BASE
import br.com.veiga.core.services.DeleteMarketService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ExtendWith(SpringExtension::class)
@WebMvcTest(controllers = [DeleteMarketController::class])
@AutoConfigureMockMvc
internal class DeleteMarketControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var service: DeleteMarketService


    @Test
    fun `delete a market`() {
        val request = delete("$URL_BASE/{id}", 1)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)

        mvc
            .perform(request)
            .andExpect(MockMvcResultMatchers.status().isNoContent)

    }
}