package com.example.multiplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FullExercise : AppCompatActivity() {
    private var firstNumber: Int = 0
    private var secondNumber: Int = 0
    private var solution: Int = 0
    private var counter: Int = 1
    private var rightAnswers: Int = 0

    private fun generateValues() {
        firstNumber = (2..9).random()
        secondNumber = (2..9).random()
        solution = firstNumber * secondNumber
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "${firstNumber} * ${secondNumber} = ???"
        val editText = findViewById<TextView>(R.id.editTextNumber2)
        editText.text = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_full_exercise)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        generateValues()

        val checkButton = findViewById<Button>(R.id.checkButton)
        checkButton.setOnClickListener {
            counter++

            var answer: Int

            try {
                answer = findViewById<EditText>(R.id.editTextNumber2).text.toString().toInt()
            } catch (e: Exception) {
                Toast.makeText(this, "Заполните поле правильно", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (answer == solution) {
                Toast.makeText(this, "Правильно", Toast.LENGTH_SHORT).show()
                rightAnswers++
            } else {
                Toast.makeText(this, "Неправильно", Toast.LENGTH_SHORT).show()
            }

            if (counter > 20) {
                val intent = Intent(this, Results::class.java)
                intent.putExtra("answers", rightAnswers)
                startActivity(intent)
                return@setOnClickListener
            }
            generateValues()
        }
    }
}