package br.com.veiga.application.controllers.v1.request

data class SearchMarketFilterRequest(
    val district: String?,
    val region05: String?,
    val name: String?,
    val neighborhood: String?
)