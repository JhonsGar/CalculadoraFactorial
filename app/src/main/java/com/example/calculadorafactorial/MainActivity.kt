package com.example.calculadorafactorial

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadorafactorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureSystemBars()

        binding.calculateButton.setOnClickListener { calculateFactorial() }
        binding.clearButton.setOnClickListener { clearForm() }
    }

    private fun calculateFactorial() {
        binding.numberInputLayout.error = null

        val rawValue = binding.numberInput.text?.toString()?.trim().orEmpty()
        val number = rawValue.toIntOrNull()

        when {
            rawValue.isBlank() -> showInputError(getString(R.string.error_empty_number))
            number == null -> showInputError(getString(R.string.error_invalid_number))
            number < 0 -> showInputError(getString(R.string.error_negative_number))
            number > MAX_FACTORIAL -> showInputError(
                getString(R.string.error_number_too_large, MAX_FACTORIAL)
            )

            else -> {
                val result = FactorialCalculator.calculate(number)
                binding.resultInput.setText(result.toString())
                binding.resultInputLayout.hint = getString(R.string.result_for_number, number)
                binding.calculationExplanation.text = getString(
                    R.string.calculation_success,
                    number,
                    result.toString().length
                )
                hideKeyboard()
            }
        }
    }

    private fun showInputError(message: String) {
        binding.numberInputLayout.error = message
        binding.resultInput.setText("")
        binding.resultInputLayout.hint = getString(R.string.result_hint)
        binding.calculationExplanation.text = getString(R.string.validation_help)
        binding.numberInput.requestFocus()
    }

    private fun clearForm() {
        binding.numberInput.text?.clear()
        binding.resultInput.setText("")
        binding.numberInputLayout.error = null
        binding.resultInputLayout.hint = getString(R.string.result_hint)
        binding.calculationExplanation.text = getString(R.string.factorial_definition)
        binding.numberInput.requestFocus()
    }

    private fun hideKeyboard() {
        getSystemService<InputMethodManager>()
            ?.hideSoftInputFromWindow(binding.numberInput.windowToken, 0)
        binding.numberInput.clearFocus()
    }

    private fun configureSystemBars() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
    }

    private companion object {
        const val MAX_FACTORIAL = 5000
    }
}

