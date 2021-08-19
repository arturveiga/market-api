package br.com.veiga.infrastructure.configurations

import br.com.veiga.core.services.CreateMarketService
import br.com.veiga.infrastructure.repositories.MarketRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration(
    private val marketRepositoryImpl: MarketRepositoryImpl
) {

    @Bean
    fun createMarketService(): CreateMarketService {
        return CreateMarketService(marketRepositoryImpl)
    }
}