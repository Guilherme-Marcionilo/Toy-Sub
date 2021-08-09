package br.com.zup

import br.com.zup.core.ports.ToyDatabaseService
import br.com.zup.infrastructure.database.ToyEntity
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.util.*

class ToyDatabaseServiceTest : AnnotationSpec() {

    private val toyDatabaseService = mockk<ToyDatabaseService>()

    private lateinit var toyEntity: ToyEntity

    @BeforeEach
    fun setUp() {
        toyEntity = ToyEntity(UUID.randomUUID(), "Test", BigDecimal.ONE, "test description")
    }

    @Test
    fun `should Unit - CREATE`() {
        every { toyDatabaseService.create(any()) } answers { toyEntity }
        val result = toyDatabaseService.create(toyEntity)
        result shouldBe Unit
    }

    @Test
    fun `should Unit - UPDATE`() {
        every { toyDatabaseService.update(any()) } answers { toyEntity }
        val result = toyDatabaseService.update(toyEntity)
        result shouldBe Unit
    }

    @Test
    fun `should Unit - DELETE`() {
        every { toyDatabaseService.delete(any()) } answers { toyEntity }
        val result = toyDatabaseService.delete(toyEntity)
        result shouldBe Unit
    }
}