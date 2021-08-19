package br.com.veiga.infrastructure.repositories

import br.com.veiga.infrastructure.models.MarketEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MarketJpaRepository : JpaRepository<MarketEntity, Long> {
}