package br.com.zup.core.mapper

import br.com.zup.core.model.Toy
import br.com.zup.infrastructure.database.ToyEntity
import br.com.zup.infrastructure.model.ToyEvent

class ToyConverter {
    companion object{
        fun toyEventToToy(toyEvent: ToyEvent)= with(toyEvent.toy){
            Toy(id, name, price, description)
        }
        fun toyToToyEntity(toy: Toy) = with(toy){
            ToyEntity(id, name, price, description)
        }

    }
}