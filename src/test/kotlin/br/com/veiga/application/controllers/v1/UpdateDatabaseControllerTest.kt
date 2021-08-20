package br.com.veiga.application.controllers.v1

import br.com.veiga.core.services.UpdateDatabaseService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@WebMvcTest(controllers = [UpdateDatabaseController::class])
@AutoConfigureMockMvc
internal class UpdateDatabaseControllerTest {
    @Autowired
    lateinit var mvc: MockMvc

    @MockBean
    lateinit var updateDatabaseService: UpdateDatabaseService


    @Test
    fun `update Storage`() {
        val request = post("/v1/markets/update-storage")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)

        mvc.perform(request)
            .andExpect(status().isCreated)
    }
}