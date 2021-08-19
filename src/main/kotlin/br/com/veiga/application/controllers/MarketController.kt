package br.com.veiga.application.controllers

import br.com.veiga.application.controllers.request.CreateMarketRequest
import br.com.veiga.application.controllers.request.UpdateMarketRequest
import br.com.veiga.application.controllers.request.extensions.toModel
import br.com.veiga.core.services.CreateMarketService
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
    private val serviceCreate: CreateMarketService
) {

    @PostMapping()
    fun create(@Valid @RequestBody request: CreateMarketRequest) = serviceCreate.save(request.toModel())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody marketRequest: UpdateMarketRequest) =
        serviceCreate.update(id, marketRequest)
}

