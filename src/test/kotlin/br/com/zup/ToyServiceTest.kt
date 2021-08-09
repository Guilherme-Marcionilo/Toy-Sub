package br.com.zup

import br.com.zup.core.model.Toy
import br.com.zup.core.ports.ToyService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.util.*

class ToyServiceTest : AnnotationSpec() {

    private val toyService = mockk<ToyService>()

    private lateinit var toy: Toy

    @BeforeEach
    fun setUp() {
        toy = Toy(UUID.randomUUID(), "Test", BigDecimal.ONE, "test description")
    }

    @Test
    fun `should Unit - CREATE`() {
        every { toyService.create(any()) } answers { toy }
        val result = toyService.create(toy)
        result shouldBe Unit
    }

    @Test
    fun `should Unit - UPDATE`() {
        every { toyService.update(any()) } answers { toy }
        val result = toyService.update(toy)
        result shouldBe Unit
    }

    @Test
    fun `should Unit - DELETE`() {
        every { toyService.delete(any()) } answers { toy }
        val result = toyService.delete(toy)
        result shouldBe Unit
    }
}