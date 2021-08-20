package br.com.veiga.core.services

import br.com.veiga.core.repositories.MarketRepository
import br.com.veiga.mocks.MarketMock
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any

@ExtendWith(MockitoExtension::class)
internal class UpdateMarketServiceTest {
    @Mock
    lateinit var repository: MarketRepository

    @InjectMocks
    lateinit var updateMarketService: UpdateMarketService

    @Test
    fun `should be a update market`() {
        val updateMarketMock = MarketMock.updateMarketMock
        val marketUpdate = MarketMock.marketUpdate

        Mockito.`when`(repository.update(any(), any())).thenReturn(marketUpdate)

        val market = updateMarketService.execute(1, updateMarketMock)

        Assertions.assertThat(market).isNotNull
        Assertions.assertThat(market.id).isNotNull
        Assertions.assertThat(market.id).isEqualTo(1)
        Assertions.assertThat(market.name).isEqualTo(marketUpdate.name)
    }
}