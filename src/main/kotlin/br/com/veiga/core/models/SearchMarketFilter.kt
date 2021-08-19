package br.com.veiga.core.models

data class SearchMarketFilter(
    val district: String? = null,
    val region05: String? = null,
    val name: String? = null,
    val neighborhood: String? = null
)
