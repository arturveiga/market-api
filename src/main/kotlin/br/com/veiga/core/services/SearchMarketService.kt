package br.com.veiga.core.services

import br.com.veiga.core.exceptions.MarketNotFoundException
import br.com.veiga.core.models.Market
import br.com.veiga.core.models.SearchMarketFilter
import br.com.veiga.core.repositories.MarketRepository

class SearchMarketService(
    private val repository: MarketRepository
) {
    fun execute(filter: SearchMarketFilter, page: Int, size: Int): List<Market> {
        return repository.findAll(filter, page, size)
    }

    fun execute(id: Long): Market {
        return repository.findById(id) ?: throw MarketNotFoundException(id)
    }
}