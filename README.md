# CalculadoraFactorial

Aplicación Android en Kotlin para calcular el factorial de un número.

## Comportamiento

- Acepta enteros desde `0` hasta `5000`.
- Rechaza campos vacíos, texto, decimales, valores negativos y valores excesivos.
- Usa `BigInteger`, por lo que no se desborda al superar el límite de `Long`.
- Presenta el resultado en un campo seleccionable y de solo lectura.
- Incluye pruebas unitarias de los casos esenciales.

## Archivos principales

- `FactorialCalculator.kt`: función matemática reutilizable.
- `MainActivity.kt`: validación y actualización de la interfaz.
- `FactorialCalculatorTest.kt`: pruebas automáticas.
- `activity_main.xml`: interfaz de entrada, botones y resultado.
