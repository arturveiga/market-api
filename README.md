# Bem vido a Api das feiras mais tops do Brasil!

Opa tá precisando fazer um gerenciamento de feiras ? Aqui está a  **MarketApi**. Uma api simples que você pode
cadastrar, editar, consultar, excluir e importar dados via csv.

## Bruxarias Utilizadas

- Kotlin
- Java 11
- PostgreSQL
- Spring Boot da massa
- Dockerzao

## Como rodar a _CRIANÇA_

Vc precisa do Java 11 <3

```sh
./gradlew clean build
./gradlew bootBuildImage
docker-compose up
```

## Cadastrando uma Feira

#### So chamar via POST

     localhost:8080/v1/markets

#### Corpinho enviado

```json
{
    "longitude": -1.2323,
    "latitude": 2.000,
    "sector": "COHAB",
    "area": "area51",
    "districtCode": "DSIS-1",
    "districtName": "DISTCTI 13",
    "subCityHallCode": 2,
    "subCityHallName": "Sant lzuiz",
    "region05": "rg05",
    "region08": "region11",
    "name": "artb",
    "register": "102304",
    "street": "rua projetada",
    "number": "1023",
    "neighborhood": "cohama",
    "reference": "felipe é meu amigao do coracao"
}
```

***Retorno bonitao***

```json
{
    "id": 1,
    "longitude": -1.2323,
    "latitude": 2.000,
    "sector": "COHAB",
    "area": "area51",
    "districtCode": "DSIS-1",
    "districtName": "DISTCTI 13",
    "subCityHallCode": 2,
    "subCityHallName": "Sant lzuiz",
    "region05": "rg05",
    "region08": "region11",
    "name": "artb",
    "register": "102304",
    "street": "rua projetada",
    "number": "1023",
    "neighborhood": "cohama",
    "reference": "felipe é meu amigao do coracao"
}
```

## E essa arquitetura ? Nao entendi foi nada

Bom esta api usa uma arquitetura inspirada no Clean Arc, onde separamos todo nosso dominio e regras de negocio (Core). A
camada de application guarda todas as entradas da api, nossos bons e velhos Controllers. E se precisar adicionar uma
fila ? Voce pode adicionar nessa camada tbm :*

A camade de core, guarda todo o fluxo da nossa aplicacao, independente se voce usa spring, quarkus ou qlr framework.

A camada de infra, guarda todos nossos frameworks e como eles fazem suas magicas, onde vc de fato salvar em um banco de
dados por exemplo.

Um exemplo de como uma chamada funciona

```mermaid
Request ->> Application: /v1/markets
Application ->> Core: CadastrarService
Core ->> Infra: Salvar em algum banco de dados
Infra ->> Core: Salvei!
Core ->> Application: Devolve um json show
```

## HMM GOSTEI TEM MAIS DOCS?

Se bateu a curiosidade do que temos a oferecer, suba o projeto e de uma olhada neste link e veja oq nossa api tem de
plus!

`http://localhost:8080/swagger-ui.html`

### Proximas evolucoes

Pensando no futuro temos algumas melhorais a ser implementada

- Uso de testes container na camada de infra
- Validar layout do CSV
- Deixe aqui sugestoes <3
