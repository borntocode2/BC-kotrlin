package com.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {

    @Test
    fun `빈 문자열이나 공백만 있는 문자열을 입력할 경우 0을 반환한다`() {
        // isEmptyInput(str) 내부의 isBlank() 로직이 정상 작동하는지 검증
        assertEquals(0, StringCalculator.calculator(""))
        assertEquals(0, StringCalculator.calculator("   "))
    }

    @Test
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`() {
        assertEquals(1, StringCalculator.calculator("1"))
        assertEquals(5, StringCalculator.calculator("5"))
    }

    @Test
    fun `쉼표(,)를 구분자로 사용하여 합을 반환한다`() {
        assertEquals(3, StringCalculator.calculator("1,2"))
    }

    @Test
    fun `콜론을 구분자로 사용하여 합을 반환한다`() {
        assertEquals(6, StringCalculator.calculator("1:2:3"))
    }

    @Test
    fun `쉼표와 콜론을 혼합하여 사용하여 합을 반환한다`() {
        assertEquals(6, StringCalculator.calculator("1,2:3"))
    }

    @Test
    fun `커스텀 구분자를 사용하여 합을 반환한다`() {
        // '//'와 '\n' 사이의 문자를 커스텀 구분자로 지정
        assertEquals(6, StringCalculator.calculator("//;\n1;2;3"))
        assertEquals(10, StringCalculator.calculator("//-\n2-3-5"))
    }

    @Test
    fun `숫자 이외의 값을 전달할 경우 RuntimeException이 발생한다`() {
        val exception = assertThrows<RuntimeException> {
            StringCalculator.calculator("1,a,3")
        }
        assertEquals("잘못된 입력입니다.", exception.message)
    }

    @Test
    fun `음수를 전달할 경우 RuntimeException이 발생한다`() {
        val exception = assertThrows<RuntimeException> {
            StringCalculator.calculator("1,-2,3")
        }
        assertEquals("음수는 허용되지 않습니다.", exception.message)
    }
}
