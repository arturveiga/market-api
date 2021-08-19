package br.com.veiga.core.services

import br.com.veiga.application.controllers.request.UpdateMarketRequest
import br.com.veiga.core.models.Market
import br.com.veiga.core.repositories.MarketRepository

class CreateMarketService(
    private val repository: MarketRepository
) {
    fun save(market: Market): Market {
        return repository.save(market)
    }

    fun update(id: Long, marketRequest: UpdateMarketRequest) {
        val market = repository.findById(id).orElseThrow { RuntimeException("Erro ao salvar tio") }
        market.copy(
            id = market.id,
            longitude = marketRequest.longitude ?: market.longitude
        )
    }

    fun deleteById(id: Long) {
        val market = repository.findById(id).orElseThrow { RuntimeException("Erro ao salvar tio") }
        repository.save(market.copy(active = false))
    }
}