package br.com.veiga.application.controllers.v1.request.extensions

import br.com.veiga.application.controllers.v1.request.UpdateMarketRequest
import br.com.veiga.core.models.UpdateMarket

fun UpdateMarketRequest.toModel(): UpdateMarket {
    return UpdateMarket(
        longitude = this.longitude,
        latitude = this.latitude,
        sector = this.sector,
        area = this.area,
        districtCode = this.districtCode,
        districtName = this.districtName,
        subCityHallCode = this.subCityHallCode,
        subCityHallName = this.subCityHallName,
        region05 = this.region05,
        region08 = this.region08,
        name = this.name,
        register = this.register,
        street = this.street,
        number = this.number,
        reference = this.reference,
        neighborhood = this.neighborhood
    )
}
