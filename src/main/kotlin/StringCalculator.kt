package com.example

class StringCalculator {
    private fun isCustomDelimiter(str: String): Boolean {
        if(str.length < 5){
            return false
        }
        else if(str.substring(0,2) == "//" && str.substring(2, 4) == "\n")
            return true

        return false
    }

    private fun getCustomDelimiter(str: String): String {

    }
}
