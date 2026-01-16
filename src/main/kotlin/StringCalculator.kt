package com.example

object StringCalculator {
    fun getCalculateSumInString(str: String): Int{
        checkNonDigit(str)

        if (isCustomDelimiter(str))
            return getSumWithDelimeter(str.substring(5), getCustomDelimiter(str))
        else
            return getCalculateSumInString(str)
    }

    private fun getSumWithDelimeter(str: String, delimeter: Char): Int {
        return str.split(delimeter).sumOf { it.toInt() }
    }

    private fun getCustomDelimiter(str: String): Char {
        if (!isCustomDelimiter(str)) throw IllegalArgumentException("Not a delimiter: $str")
        else return str[2]
    }

    private fun isCustomDelimiter(str: String): Boolean {
        if(str.length < 5){
            return false
        }
        else if(str.substring(0,2) == "//" && str.substring(2, 4) == "\n")
            return true

        return false
    }

    private fun checkNonDigit(str: String){
        for (i in str){
            if (i !in '0'..'9'){
                throw IllegalArgumentException("Invalid input: $str")
            }
        }
    }
}
