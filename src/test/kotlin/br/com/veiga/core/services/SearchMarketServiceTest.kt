package br.com.veiga.core.services

import br.com.veiga.core.exceptions.MarketNotFoundException
import br.com.veiga.core.models.SearchMarketFilter
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
internal class SearchMarketServiceTest {
    @Mock
    lateinit var repository: MarketRepository

    @InjectMocks
    lateinit var searchMarketService: SearchMarketService

    @Test
    fun `should be a list market`() {
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

        val filter = SearchMarketFilter()

        Mockito.`when`(repository.findAll(any(), any(), any())).thenReturn(marketsMock)

        val markets = searchMarketService.execute(filter, 1, 20)

        Assertions.assertThat(markets).isNotEmpty
    }

    @Test
    fun `should be find Market by ID`() {
        Mockito.`when`(repository.findById(any())).thenReturn(MarketMock.market)

        val market = searchMarketService.execute(any())

        Assertions.assertThat(market.id).isNotNull
    }

    @Test
    fun `should be a exception when id is not found`() {
        Mockito.`when`(repository.findById(any())).thenThrow(MarketNotFoundException::class.java)

        Assertions.assertThatThrownBy {
            searchMarketService.execute(any())
        }
            .isInstanceOf(MarketNotFoundException::class.java)
    }

}