package br.com.veiga.core.services

import br.com.veiga.core.exceptions.MarketNotFoundException
import br.com.veiga.core.repositories.MarketRepository

class DeleteMarketService(
    private val repository: MarketRepository
) {
    fun execute(id: Long) {
        val market = repository.findById(id) ?: throw MarketNotFoundException(id)
        repository.save(market.copy(active = false))
    }
}