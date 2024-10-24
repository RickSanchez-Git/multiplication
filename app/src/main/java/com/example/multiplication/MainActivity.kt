package com.example.multiplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fullExerciseButton = findViewById<Button>(R.id.fullExercise)
        val chooseExerciseButton = findViewById<Button>(R.id.chooseExercise)
        fullExerciseButton.setOnClickListener {
            startActivity(Intent(this, FullExercise::class.java))
        }
        chooseExerciseButton.setOnClickListener {
            var selectedNumber: Int
            try {
                selectedNumber = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
                if (selectedNumber > 9 || selectedNumber < 1) {
                    throw Exception()
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Заполните поле правильно", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, ChooseExercise::class.java)
            intent.putExtra("number", selectedNumber)
            startActivity(intent)
        }
    }
}