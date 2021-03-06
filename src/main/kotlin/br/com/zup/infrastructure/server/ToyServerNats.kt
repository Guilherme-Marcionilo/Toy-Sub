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

    private val LOG = LoggerFactory.getLogger(this::class.java)

    @Subject("channel.toy")
    fun listen(toyEvent: ToyEvent){
        LOG.info("Connection Sucess - Infrastructure | Running Operation")

        when (toyEvent.takeAction) {
            REGISTER -> {
                toyService.create(ToyConverter.toyEventToToy(toyEvent))
            }
            UPDATE -> {
                toyService.update(ToyConverter.toyEventToToy(toyEvent))
            }
            DELETE -> {
                toyService.delete(ToyConverter.toyEventToToy(toyEvent))
            }
        }

    }

}