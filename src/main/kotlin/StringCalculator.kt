package com.example

object StringCalculator {
    fun calculator(str: String): Int {
        val regex = """^//(.)\n(.*)""".toRegex()
        val matchResult = regex.find(str)
        val stringNumbers: List<String>

        if(matchResult == null){
            stringNumbers = extractStringNumbersByRegularDelimeters(str)
        }else{
            stringNumbers = extractStringNumbersByCustomDelimeter(matchResult.groupValues[1], matchResult.groupValues[2])
        }

        //TODO: stringNumbers가 음수거나, 숫자가 아닌 값이 들어있는지 예외 처리
        //TODO: 예외에 통과됐다면, calculateSumByStringNumbers를 활용하여 output 출력

    }

    private fun extractStringNumbersByCustomDelimeter(delimeter: String, str: String): List<String>{
        return str.split(delimeter)

    }

    private fun extractStringNumbersByRegularDelimeters(str: String): List<String>{
        return str.split(":", ",")
    }

    private fun calculateSumByStringNumbers(stringNumbers: String){

    }
}
