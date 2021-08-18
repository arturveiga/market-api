package br.com.veiga.controllers

import br.com.veiga.controllers.request.CreateMarketRequest
import br.com.veiga.controllers.request.MarketUpdateRequest
import br.com.veiga.controllers.request.extensions.toModel
import br.com.veiga.services.MarketService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/v1/markets")
class MarketController(
    private val service: MarketService
) {

    @PostMapping()
    fun create(@Valid @RequestBody request: CreateMarketRequest) = service.save(request.toModel())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: MarketUpdateRequest) = service.update(id, request)
}

