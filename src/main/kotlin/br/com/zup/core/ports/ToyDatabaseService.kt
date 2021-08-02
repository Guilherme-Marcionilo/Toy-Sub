package br.com.zup.core.ports

import br.com.zup.infrastructure.database.ToyEntity

interface ToyDatabaseService {
    fun create(toy: ToyEntity)
}