package br.com.veiga.application.controllers.v1

import br.com.veiga.application.controllers.v1.mapping.MarketV1RestMapping
import br.com.veiga.core.services.UpdateDatabaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseStatus

@MarketV1RestMapping
class UpdateDatabaseController(
    private val updateDatabaseService: UpdateDatabaseService
) {

    @PostMapping("/update-storage")
    @ResponseStatus(HttpStatus.CREATED)
    fun execute() {
        updateDatabaseService.execute()
    }
}