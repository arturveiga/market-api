package br.com.veiga.infrastructure.repositories

import br.com.veiga.core.models.Market
import br.com.veiga.core.repositories.MarketRepository
import br.com.veiga.infrastructure.repositories.extensions.toEntity
import br.com.veiga.infrastructure.repositories.extensions.toModel
import org.springframework.stereotype.Component
import java.util.Optional

@Component
class MarketRepositoryImpl(
    private val jpaRepository: MarketJpaRepository
) : MarketRepository {

    override fun save(market: Market): Market {
        val marketEntity = market.toEntity()
        return jpaRepository.save(marketEntity).toModel()
    }

    override fun findById(id: Long): Optional<Market> {
        val marketEntity = jpaRepository.findById(id).orElseThrow { RuntimeException("Not found") }
        return Optional.of(marketEntity.toModel())
    }
}