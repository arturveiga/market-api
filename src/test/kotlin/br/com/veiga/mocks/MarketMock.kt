package br.com.veiga.mocks

import br.com.veiga.core.models.Market

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
    }
}