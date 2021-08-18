package br.com.veiga.repositories

import br.com.veiga.models.Market
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MarketRepository : JpaRepository<Market, Long>