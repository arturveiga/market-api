package br.com.veiga.services

import br.com.veiga.controllers.request.MarketUpdateRequest
import br.com.veiga.models.Market
import br.com.veiga.repositories.MarketRepository
import org.springframework.stereotype.Service

@Service
class MarketService(
    private val repository: MarketRepository
) {
    fun save(market: Market): Market {
        return repository.save(market)
    }

    fun update(id: Long, request: MarketUpdateRequest) {
        val market = repository.findById(id).orElseThrow { RuntimeException("Erro ao salvar tio") }
        market.copy(
            id = market.id,
            longitude = request.longitude ?: market.longitude
        )
    }

    fun deleteById(id: Long) {
        val market = repository.findById(id).orElseThrow { RuntimeException("Erro ao salvar tio") }
        repository.save(market.copy(active = false))
    }
}