package br.com.zup.core.ports

import br.com.zup.core.model.Toy

interface ToyService {
    fun create(dto: Toy)
    fun update(dto: Toy)
    fun delete(dto: Toy)
}