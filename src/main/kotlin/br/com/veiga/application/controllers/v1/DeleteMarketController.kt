package br.com.veiga.application.controllers.v1

import br.com.veiga.core.services.DeleteMarketService
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus

@MarketV1RestMapping
class DeleteMarketController(
    private val deleteMarketService: DeleteMarketService
) {

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    fun execute(@PathVariable id: Long) {
        deleteMarketService.execute(id)
    }
}