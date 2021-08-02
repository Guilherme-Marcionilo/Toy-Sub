package br.com.zup.infrastructure.database

import br.com.zup.core.ports.ToyDatabaseService
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class ToyDatabaseImpl(private val cqlSession: CqlSession) : ToyDatabaseService {

    override fun create(toy: ToyEntity) {
        toy.id = UUID.randomUUID()
        cqlSession.execute(
            SimpleStatement.newInstance(
                "INSERT INTO toy(id, name, price, description) VALUES (?,?,?,?)",
                toy.id,
                toy.name,
                toy.price,
                toy.description
            )
        )
    }

    override fun update(toy: ToyEntity) {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "UPDATE toy SET name = ?, price = ?, description = ? WHERE id = ?",
                toy.name,
                toy.price,
                toy.description,
                toy.id,
            )
        )
    }

    override fun delete(toy: ToyEntity) {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "DELETE from toy WHERE id = ?",
                toy.id,
            )
        )
    }
}