package br.com.veiga.core.services

import br.com.veiga.core.repositories.UpdateDatabaseRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.atLeastOnce
import org.mockito.kotlin.verify

@ExtendWith(MockitoExtension::class)
internal class UpdateDatabaseServiceTest {

    @Mock
    lateinit var updateDatabaseRepository: UpdateDatabaseRepository

    @InjectMocks
    lateinit var updateDatabaseService: UpdateDatabaseService

    @Test
    fun `should be update storage`() {
        updateDatabaseService.execute()

        verify(updateDatabaseRepository, atLeastOnce()).execute()
    }
}
