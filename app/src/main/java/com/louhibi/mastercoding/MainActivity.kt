package com.louhibi.mastercoding

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var result: TextView
    private var currentInput = StringBuilder()
    private var operator: String? = null
    private var operand1: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.Result)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnadd, R.id.btnclear, R.id.btndivide,
            R.id.btnmul, R.id.btnequal, R.id.btnsub
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener { onButtonClick(it as Button) }
        }
    }

    private fun onButtonClick(button: Button) {
        val buttonText = button.text.toString()
        when (buttonText) {
            "C" -> {
                currentInput.clear()
                operator = null
                operand1 = null
                result.text = "0"
            }
            "=" -> {
                val operand2 = currentInput.toString().toDoubleOrNull()
                if (operand1 != null && operator != null && operand2 != null) {
                    val resultTXT = calculateResult(operand1!!, operand2, operator!!)
                    result.text = resultTXT.toString()
                    currentInput.clear().append(resultTXT)
                    operator = null
                    operand1 = null
                }
            }
            "+", "-", "*", "/" -> {
                if (currentInput.isNotEmpty()) {
                    operand1 = currentInput.toString().toDoubleOrNull()
                    operator = buttonText
                    currentInput.clear()
                }
            }
            else -> {
                currentInput.append(buttonText)
                result.text = currentInput.toString()
            }
        }
    }

    private fun calculateResult(operand1: Double, operand2: Double, operator: String): Any {
        return when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            else -> 0.0
        }
    }
}