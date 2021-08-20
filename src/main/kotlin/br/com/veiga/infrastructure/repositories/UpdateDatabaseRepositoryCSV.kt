package br.com.veiga.infrastructure.repositories

import br.com.veiga.core.repositories.UpdateDatabaseRepository
import br.com.veiga.infrastructure.models.MarketEntity
import br.com.veiga.infrastructure.repositories.jpa.MarketJpaRepository
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.springframework.stereotype.Component

@Component
class UpdateDatabaseRepositoryCSV(
    private val marketJpaRepository: MarketJpaRepository
) : UpdateDatabaseRepository {
    override fun execute() {
        val markets = mutableListOf<MarketEntity>()

        csvReader(init = {
            skipMissMatchedRow = true
        })
            .open("src/main/resources/DEINFO_AB_FEIRASLIVRES_2014.csv") {
                readAllWithHeaderAsSequence().forEach { row: Map<String, String> ->
                    val marketEntity = MarketEntity(
                        id = row["ID"]?.toLong(),
                        longitude = row["LONG"]?.toDouble() ?: 0.0,
                        latitude = row["LAT"]?.toDouble() ?: 0.0,
                        sector = row["SETCENS"] ?: "",
                        area = row["AREAP"] ?: "",
                        districtCode = row["CODDIST"] ?: "",
                        districtName = row["DISTRITO"] ?: "",
                        subCityHallCode = row["CODSUBPREF"]?.toLong() ?: 0,
                        subCityHallName = row["SUBPREFE"] ?: "",
                        region05 = row["REGIAO5"] ?: "",
                        region08 = row["REGIAO8"] ?: "",
                        name = row["NOME_FEIRA"] ?: "",
                        register = row["REGISTRO"] ?: "",
                        street = row["LOGRADOURO"] ?: "",
                        number = row["NUMERO"] ?: "",
                        neighborhood = row["BAIRRO"] ?: "",
                        reference = row["BAIRRO"] ?: "",
                        active = true
                    )

                    marketEntity.id?.let {
                        println(marketEntity.id)
                        val optionalMarket = marketJpaRepository.findById(it)
                        if (!optionalMarket.isPresent) {
                            markets.add(marketEntity)
                        }
                    }
                }
            }

        marketJpaRepository.saveAll(markets)
    }


}