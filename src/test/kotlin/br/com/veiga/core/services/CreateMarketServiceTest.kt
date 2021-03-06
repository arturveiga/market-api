package br.com.veiga.core.services

import br.com.veiga.core.models.Market
import br.com.veiga.core.repositories.MarketRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any

@ExtendWith(MockitoExtension::class)
internal class CreateMarketServiceTest {
    @Mock
    lateinit var repository: MarketRepository

    @InjectMocks
    lateinit var serviceCreate: CreateMarketService

    private val market = Market(
        id = 1,
        longitude = -1.203203,
        latitude = 2.3213213,
        sector = "sector dummy",
        area = "area",
        districtCode = "1230",
        districtName = "Sao luis",
        subCityHallCode = 1,
        subCityHallName = "Cohama",
        region05 = "West",
        region08 = "North",
        name = "Feira da CO",
        register = "7210-9",
        street = "RUA JOSE MARTINS DOS SANTOS",
        number = "s/n",
        neighborhood = "VL FORMOSA",
        reference = "TV RUA PRETORIA"
    )

    @Test
    fun `should be create a new market`() {
        val marketToSave = market.copy(id = null)
        Mockito.`when`(repository.save(any())).thenReturn(market)

        val marketSaved = serviceCreate.execute(marketToSave)

        Assertions.assertThat(marketSaved).isNotNull
    }
}