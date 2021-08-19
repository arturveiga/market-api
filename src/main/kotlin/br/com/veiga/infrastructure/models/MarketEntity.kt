package br.com.veiga.infrastructure.models

data class MarketEntity(
    val id: Long? = null,
    val longitude: Double,
    val latitude: Double,
    val sector: String,
    val area: String,
    val districtCode: String,
    val districtName: String,
    val subCityHallCode: Long,
    val subCityHallName: String,
    val region05: String,
    val region08: String,
    val name: String,
    val register: String,
    val street: String,
    val number: String,
    val neighborhood: String,
    val reference: String
)
