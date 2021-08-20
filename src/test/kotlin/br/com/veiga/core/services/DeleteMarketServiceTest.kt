package br.com.veiga.core.services

import br.com.veiga.core.exceptions.MarketNotFoundException
import br.com.veiga.core.models.Market
import br.com.veiga.core.repositories.MarketRepository
import br.com.veiga.mocks.MarketMock
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.argumentCaptor

@ExtendWith(MockitoExtension::class)
internal class DeleteMarketServiceTest {
    @Mock
    lateinit var repository: MarketRepository

    @InjectMocks
    lateinit var deleteMarketService: DeleteMarketService

    @Test
    fun `should be delete market`() {
        Mockito.`when`(repository.findById(Mockito.anyLong())).thenReturn(MarketMock.market)

        deleteMarketService.execute(anyLong())

        val captor = argumentCaptor<Market>()

        Mockito.verify(repository).save(captor.capture())

        Assertions.assertThat(captor.firstValue.active).isFalse
    }

    @Test
    fun `should be a market not found exception`() {
        Mockito.`when`(repository.findById(Mockito.anyLong())).thenReturn(null)

        Assertions.assertThatThrownBy {
            deleteMarketService.execute(anyLong())
        }
            .isInstanceOf(MarketNotFoundException::class.java)
    }
}