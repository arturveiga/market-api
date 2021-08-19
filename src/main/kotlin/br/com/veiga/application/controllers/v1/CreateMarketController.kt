package br.com.veiga.application.controllers.v1

import br.com.veiga.application.controllers.v1.mapping.MarketV1RestMapping
import br.com.veiga.application.controllers.v1.request.CreateMarketRequest
import br.com.veiga.application.controllers.v1.request.extensions.toModel
import br.com.veiga.application.controllers.v1.response.MarketResponse
import br.com.veiga.application.controllers.v1.response.toResponse
import br.com.veiga.core.services.CreateMarketService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

@MarketV1RestMapping
class CreateMarketController(
    private val serviceCreate: CreateMarketService
) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun create(@Valid @RequestBody request: CreateMarketRequest): MarketResponse {
        val market = serviceCreate.execute(request.toModel())
        return market.toResponse()
    }
}