package br.com.veiga.core.repositories

import br.com.veiga.core.models.Market
import br.com.veiga.core.models.SearchMarketFilter
import br.com.veiga.core.models.UpdateMarket

interface MarketRepository {
    fun save(market: Market): Market
    fun findById(id: Long): Market?
    fun findAll(filter: SearchMarketFilter, page: Int, size: Int): List<Market>
    fun delete(id: Long)
    fun update(id: Long, updateMarket: UpdateMarket): Market
}