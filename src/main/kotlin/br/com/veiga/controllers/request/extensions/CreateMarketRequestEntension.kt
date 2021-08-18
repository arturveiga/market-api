package br.com.veiga.controllers.request.extensions

import br.com.veiga.controllers.request.CreateMarketRequest
import br.com.veiga.models.Market

fun CreateMarketRequest.toModel(): Market {
    return Market(
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
        name = this.region08,
        register = this.register,
        street = this.street,
        number = this.number,
        reference = this.reference,
        neighborhood = this.neighborhood
    )
}