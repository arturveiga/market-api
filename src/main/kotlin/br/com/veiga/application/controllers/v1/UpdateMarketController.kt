package br.com.veiga.application.controllers.v1

import br.com.veiga.application.controllers.v1.mapping.MarketV1RestMapping
import br.com.veiga.application.controllers.v1.request.UpdateMarketRequest
import br.com.veiga.application.controllers.v1.request.extensions.toModel
import br.com.veiga.application.controllers.v1.response.MarketResponse
import br.com.veiga.application.controllers.v1.response.toResponse
import br.com.veiga.core.services.UpdateMarketService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@MarketV1RestMapping
class UpdateMarketController(
    private val updateMarketService: UpdateMarketService
) {

    @PutMapping("/{id}")
    fun execute(@PathVariable id: Long, @RequestBody updateMarketRequest: UpdateMarketRequest): MarketResponse {
        return updateMarketService.execute(
            id,
            updateMarketRequest.toModel()
        ).toResponse()
    }
}