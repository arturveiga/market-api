package br.com.veiga.infrastructure.repositories

import br.com.veiga.core.models.Market
import br.com.veiga.core.models.SearchMarketFilter
import br.com.veiga.core.repositories.MarketRepository
import br.com.veiga.infrastructure.models.MarketEntity
import br.com.veiga.infrastructure.repositories.extensions.toEntity
import br.com.veiga.infrastructure.repositories.extensions.toModel
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root


@Repository
class MarketRepositoryImpl(
    private val jpaRepository: MarketJpaRepository,
    private val entityManager: EntityManager
) : MarketRepository {

    override fun save(market: Market): Market {
        val marketEntity = market.toEntity()
        return jpaRepository.save(marketEntity).toModel()
    }

    override fun findById(id: Long): Market {
        val marketEntity = jpaRepository.findById(id).orElseThrow { RuntimeException("Not found") }
        return marketEntity.toModel()
    }

    override fun findAll(filter: SearchMarketFilter, page: Int, size: Int): List<Market> {

        val criteriaBuilder: CriteriaBuilder = entityManager.criteriaBuilder
        val criteriaQuery: CriteriaQuery<MarketEntity> = criteriaBuilder.createQuery(
            MarketEntity::class.java
        )
        val market = criteriaQuery.from(MarketEntity::class.java)
        val markerRoot: Root<MarketEntity> = criteriaQuery.from(MarketEntity::class.java)
        val predicates = mutableListOf<Predicate>()

        filter.district?.let {
            predicates.add(criteriaBuilder.equal(markerRoot.get<String>("districtName"), it))
        }

        filter.region05?.let {
            predicates.add(criteriaBuilder.equal(markerRoot.get<String>("region05"), it))
        }

        filter.name?.let {
            predicates.add(criteriaBuilder.equal(markerRoot.get<String>("name"), it))
        }

        filter.neighborhood?.let {
            predicates.add(criteriaBuilder.equal(markerRoot.get<String>("neighborhood"), it))
        }

        criteriaQuery.select(market)
            .where(criteriaBuilder.or(*predicates.toTypedArray()))

        val resultList = entityManager.createQuery(criteriaQuery)
            .setFirstResult(page)
            .setMaxResults(size)
            .resultList

        return resultList.map {
            it.toModel()
        }.toList()
    }
}