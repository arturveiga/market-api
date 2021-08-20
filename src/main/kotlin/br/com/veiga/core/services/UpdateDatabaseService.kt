package br.com.veiga.core.services

import br.com.veiga.core.repositories.UpdateDatabaseRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class UpdateDatabaseService(
    private val updateDatabaseRepository: UpdateDatabaseRepository
) {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    fun execute() {
        log.info("action=UpdateDatabaseService Update Database")
        updateDatabaseRepository.execute()
    }
}