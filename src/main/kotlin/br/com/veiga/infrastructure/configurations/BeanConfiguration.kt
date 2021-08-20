package br.com.veiga.infrastructure.configurations

import br.com.veiga.core.services.CreateMarketService
import br.com.veiga.core.services.DeleteMarketService
import br.com.veiga.core.services.SearchMarketService
import br.com.veiga.core.services.UpdateMarketService
import br.com.veiga.infrastructure.repositories.MarketRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration() {

    @Bean
    fun createMarketService(marketRepositoryImpl: MarketRepositoryImpl): CreateMarketService {
        return CreateMarketService(marketRepositoryImpl)
    }

    @Bean
    fun searchMarketService(marketRepositoryImpl: MarketRepositoryImpl): SearchMarketService {
        return SearchMarketService(marketRepositoryImpl)
    }

    @Bean
    fun deleteMarketService(marketRepositoryImpl: MarketRepositoryImpl): DeleteMarketService {
        return DeleteMarketService(marketRepositoryImpl)
    }

    @Bean
    fun updateMarketService(marketRepositoryImpl: MarketRepositoryImpl): UpdateMarketService {
        return UpdateMarketService(marketRepositoryImpl)
    }
}