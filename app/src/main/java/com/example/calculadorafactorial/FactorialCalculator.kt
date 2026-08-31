package com.example.calculadorafactorial

import java.math.BigInteger

object FactorialCalculator {

    /**
     * Calcula n! sin el límite de tamaño de Int o Long.
     */
    fun calculate(number: Int): BigInteger {
        require(number >= 0) { "El número no puede ser negativo." }

        var result = BigInteger.ONE
        for (factor in 2..number) {
            result = result.multiply(BigInteger.valueOf(factor.toLong()))
        }
        return result
    }
}

