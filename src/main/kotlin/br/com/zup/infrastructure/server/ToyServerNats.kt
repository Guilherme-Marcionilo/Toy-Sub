package br.com.zup.infrastructure.server

import br.com.zup.core.mapper.ToyConverter
import br.com.zup.core.ports.ToyService
import br.com.zup.infrastructure.enum.TakeAction.*
import br.com.zup.infrastructure.model.ToyEvent
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.LoggerFactory

@NatsListener
class ToyServerNats(private val toyService: ToyService) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Subject("channel.toy")
    fun listen(toyEvent: ToyEvent){
        logger.info("Connection Sucess and CREATED - Infrastructure")

        if(toyEvent.takeAction == REGISTER){
            toyService.create(ToyConverter.toyEventToToy(toyEvent))
        }

    }

}