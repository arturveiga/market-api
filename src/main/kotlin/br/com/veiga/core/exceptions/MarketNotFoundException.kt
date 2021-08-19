package br.com.veiga.core.exceptions

class MarketNotFoundException(id: Long) : BusinessException("Market not found by id: $id")