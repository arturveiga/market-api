package br.com.veiga.core.repositories

import br.com.veiga.core.models.Market
import java.util.Optional

interface MarketRepository {
    fun save(market: Market): Market
    fun findById(id: Long): Optional<Market>
}