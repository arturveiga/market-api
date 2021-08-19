package br.com.veiga.infrastructure.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class MarketEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
