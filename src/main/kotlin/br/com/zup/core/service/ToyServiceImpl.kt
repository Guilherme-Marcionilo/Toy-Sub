package br.com.zup.core.service

import br.com.zup.core.mapper.ToyConverter
import br.com.zup.core.model.Toy
import br.com.zup.core.ports.ToyDatabaseService
import br.com.zup.core.ports.ToyService
import javax.inject.Singleton

@Singleton
class ToyServiceImpl(private val toyDatabaseService: ToyDatabaseService): ToyService {

    override fun create(dto: Toy) = toyDatabaseService.create(ToyConverter.toyToToyEntity(dto))


}