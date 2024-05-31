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

    }
}