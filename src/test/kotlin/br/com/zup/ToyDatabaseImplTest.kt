package br.com.zup

import br.com.zup.infrastructure.database.ToyDatabaseImpl
import br.com.zup.infrastructure.database.ToyEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import java.math.BigDecimal
import java.util.*

class ToyDatabaseImplTest : AnnotationSpec() {

    private val cqlSession = mockk<CqlSession>(relaxed = true)
    private val toyDatabaseImpl = ToyDatabaseImpl(cqlSession)
    private lateinit var toyEntity: ToyEntity

    @BeforeEach
    fun setUp() {
        toyEntity = ToyEntity(UUID.randomUUID(), "Test", BigDecimal.ONE, "Desc")
    }

    @Test
    fun `should return sucess when save toy Entity`() {
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "INSERT INTO toy.Toy(id,name, price, description) VALUES (?,?,?,?)",
                    UUID.randomUUID(),
                    toyEntity.name,
                    toyEntity.price,
                    toyEntity.description
                )
        )
        val result = toyDatabaseImpl.create(toyEntity)
        result shouldBe Unit
    }

    @Test
    fun `should update a toy`() {
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "UPDATE toy.Toy SET name = ?, price = ?, description = ? WHERE id = ?",
                    toyEntity.name,
                    toyEntity.price,
                    toyEntity.description,
                    toyEntity.id
                )
        )
        val result = toyDatabaseImpl.update(toyEntity)
        result shouldBe Unit
    }

    @Test
    fun `should delete a toy by ID `() {
        val id = UUID.randomUUID()

        cqlSession.execute(
            SimpleStatement
                .newInstance("DELETE from toy.Toy where ID = ?", id)
        )
        val result = toyDatabaseImpl.delete(toyEntity)

        result shouldBe Unit
    }

}