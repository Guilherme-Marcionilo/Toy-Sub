package br.com.zup.infrastructure.model

import java.math.BigDecimal
import java.util.*

data class ToyDto(
    var id: UUID? = null,
    val name: String,
    val price: BigDecimal,
    val description: String
)
