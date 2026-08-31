package com.example.calculadorafactorial

import java.math.BigInteger
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class FactorialCalculatorTest {

    @Test
    fun `factorial de cero es uno`() {
        assertEquals(BigInteger.ONE, FactorialCalculator.calculate(0))
    }

    @Test
    fun `factorial de uno es uno`() {
        assertEquals(BigInteger.ONE, FactorialCalculator.calculate(1))
    }

    @Test
    fun `factorial de tres es seis`() {
        assertEquals(BigInteger.valueOf(6), FactorialCalculator.calculate(3))
    }

    @Test
    fun `factorial de cinco es ciento veinte`() {
        assertEquals(BigInteger.valueOf(120), FactorialCalculator.calculate(5))
    }

    @Test
    fun `factorial de diez es correcto`() {
        assertEquals(BigInteger.valueOf(3_628_800), FactorialCalculator.calculate(10))
    }

    @Test
    fun `un numero negativo produce error`() {
        assertThrows(IllegalArgumentException::class.java) {
            FactorialCalculator.calculate(-1)
        }
    }
}

