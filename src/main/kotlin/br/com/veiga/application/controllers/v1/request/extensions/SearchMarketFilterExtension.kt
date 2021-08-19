package br.com.veiga.application.controllers.v1.request.extensions

import br.com.veiga.application.controllers.v1.request.SearchMarketFilterRequest
import br.com.veiga.core.models.SearchMarketFilter

fun SearchMarketFilterRequest.toModel(): SearchMarketFilter {
    return SearchMarketFilter(
        district = this.district,
        region05 = this.region05,
        name = this.name,
        neighborhood = this.neighborhood
    )
}