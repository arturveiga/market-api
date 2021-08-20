package br.com.veiga.core.services

import br.com.veiga.core.models.Market
import br.com.veiga.core.models.UpdateMarket
import br.com.veiga.core.repositories.MarketRepository

class UpdateMarketService(
    private val repository: MarketRepository
) {
    fun execute(id: Long, updateMarket: UpdateMarket): Market {
        return repository.update(id, updateMarket)
    }
}