package br.com.veiga.application.controllers.v1

import br.com.veiga.application.controllers.v1.request.SearchMarketFilterRequest
import br.com.veiga.application.controllers.v1.request.extensions.toModel
import br.com.veiga.application.controllers.v1.response.MarketResponse
import br.com.veiga.application.controllers.v1.response.toResponse
import br.com.veiga.core.services.SearchMarketService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@MarketV1RestMapping
class SearchMarketController(
    private val searchMarketService: SearchMarketService
) {
    @GetMapping
    fun execute(searchMarketFilterRequest: SearchMarketFilterRequest, pageable: Pageable): Page<MarketResponse> {
        println(searchMarketFilterRequest)
        val markets = searchMarketService.execute(
            filter = searchMarketFilterRequest.toModel(),
            page = pageable.pageNumber,
            size = pageable.pageSize
        )
        val marketsResponse = markets.map { it.toResponse() }.toList()
        return PageImpl(marketsResponse)
    }

    @GetMapping("/{id}")
    fun execute(@PathVariable id: Long): MarketResponse {
        return searchMarketService.execute(id).toResponse()
    }
}
