package br.com.veiga.core.services

import br.com.veiga.core.models.Market
import br.com.veiga.core.repositories.MarketRepository

class CreateMarketService(
    private val repository: MarketRepository
) {
    fun execute(market: Market): Market {
        return repository.save(market)
    }
}