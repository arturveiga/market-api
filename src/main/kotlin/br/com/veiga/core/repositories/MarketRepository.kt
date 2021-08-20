package br.com.veiga.core.repositories

import br.com.veiga.core.models.Market
import br.com.veiga.core.models.SearchMarketFilter

interface MarketRepository {
    fun save(market: Market): Market
    fun findById(id: Long): Market?
    fun findAll(filter: SearchMarketFilter?, page: Int, size: Int): List<Market>
    fun delete(id: Long)
}