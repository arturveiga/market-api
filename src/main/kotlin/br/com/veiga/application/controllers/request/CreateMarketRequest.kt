package br.com.veiga.application.controllers.request

import javax.validation.constraints.NotBlank

data class CreateMarketRequest(
    val longitude: Double,
    val latitude: Double,
    @field:NotBlank
    val sector: String,
    @field:NotBlank
    val area: String,
    @field:NotBlank
    val districtCode: String,
    @field:NotBlank
    val districtName: String,
    val subCityHallCode: Long,
    @field:NotBlank
    val subCityHallName: String,
    @field:NotBlank
    val region05: String,
    @field:NotBlank
    val region08: String,
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val register: String,
    @field:NotBlank
    val street: String,
    @field:NotBlank
    val number: String,
    @field:NotBlank
    val neighborhood: String,
    @field:NotBlank
    val reference: String,
)