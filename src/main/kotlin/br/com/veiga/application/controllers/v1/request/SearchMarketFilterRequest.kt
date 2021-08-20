package br.com.veiga.application.controllers.v1.request

data class SearchMarketFilterRequest(
    val district: String? = null,
    val region05: String? = null,
    val name: String? = null,
    val neighborhood: String? = null
)