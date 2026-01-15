package com.example
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test

@DisplayName("Simple Calculator 테스트")
class SimpleCalculatorTest {
    @Test
    fun addition() {
        val result = SimpleCalculator.add(1, 2)
        val expected = 3

        assertEquals(expected, result)
    }

    @Test
    fun subtraction() {
        val result = SimpleCalculator.subtract(1, 2)
        val expected = -1

        assertEquals(expected, result)
    }

    @Test
    fun multiplication() {
        val result = SimpleCalculator.multiply(1, 2)
        val expected = 2

        assertEquals(expected, result)
    }

    @Test
    fun division() {
        val result = SimpleCalculator.divide(2, 1)
        val expected = 2
        assertEquals(expected, result)
    }
}
