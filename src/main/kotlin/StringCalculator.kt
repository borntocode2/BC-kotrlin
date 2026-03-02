package com.example

object StringCalculator {
    fun calculator(str: String): Int {
        if (isEmptyInput(str)){ return 0 }

        val regex = """^//(.)\n(.*)""".toRegex()
        val matchResult = regex.find(str)
        val stringNumbers: List<String>

        if (matchResult == null) {
            stringNumbers = extractStringNumbersByRegularDelimeters(str)
        } else {
            stringNumbers =
                extractStringNumbersByCustomDelimeter(matchResult.groupValues[1], matchResult.groupValues[2])
        }

        validateLegalInput(stringNumbers)
        return calculateSumStringNumbers(stringNumbers)
    }

    private fun extractStringNumbersByCustomDelimeter(delimeter: String, str: String): List<String> {
        return str.split(delimeter)
    }

    private fun extractStringNumbersByRegularDelimeters(str: String): List<String> {
        return str.split(":", ",")
    }

    private fun calculateSumStringNumbers(stringNumbers: List<String>) = stringNumbers.sumOf { it.toInt() }


    private fun validateLegalInput(stringNumbers: List<String>) {
        stringNumbers.forEach {
            val num = it.toIntOrNull() ?: throw RuntimeException("잘못된 입력입니다.")

            if (num < 0){
                throw RuntimeException("음수는 허용되지 않습니다.")
            }
        }
    }

    private fun isEmptyInput(str: String) = str.isBlank()
}
