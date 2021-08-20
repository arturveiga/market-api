package br.com.veiga.mocks

import br.com.veiga.application.controllers.v1.request.CreateMarketRequest
import br.com.veiga.application.controllers.v1.response.MarketResponse
import br.com.veiga.core.models.Market
import br.com.veiga.core.models.UpdateMarket

class MarketMock {
    companion object {
        val market = Market(
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

        val marketUpdate = Market(
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
            name = "Market XP",
            register = "7210-9",
            street = "RUA JOSE MARTINS DOS SANTOS",
            number = "s/n",
            neighborhood = "VL FORMOSA",
            reference = "TV RUA PRETORIA"
        )

        val createMarketRequest = CreateMarketRequest(
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

        val marketResponse = MarketResponse(
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

        val updateMarketMock = UpdateMarket(
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
    }
}