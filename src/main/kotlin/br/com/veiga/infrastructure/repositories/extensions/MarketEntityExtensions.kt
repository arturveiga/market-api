package br.com.veiga.infrastructure.repositories.extensions

import br.com.veiga.core.models.Market
import br.com.veiga.infrastructure.models.MarketEntity

fun MarketEntity.toModel(): Market {
    return (
        Market(
            id = this.id,
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
        )
}

fun Market.toEntity(): MarketEntity {
    return MarketEntity(
        id = this.id,
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
        reference = this.reference,
        active = this.active
    )
}