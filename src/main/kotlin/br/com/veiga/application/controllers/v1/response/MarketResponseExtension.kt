package br.com.veiga.application.controllers.v1.response

import br.com.veiga.core.models.Market

fun Market.toResponse(): MarketResponse {
    return MarketResponse(
        id = this.id ?: 0,
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
        neighborhood = this.neighborhood,
        reference = this.reference
    )
}