package br.com.zup.infrastructure.database

import java.math.BigDecimal
import java.util.*

data class ToyEntity(
    var id: UUID? = null,
    val name: String,
    val price: BigDecimal,
    val description: String
)
