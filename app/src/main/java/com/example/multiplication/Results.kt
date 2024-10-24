package com.example.multiplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Results : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val results = intent.getIntExtra("answers", 0)

        val textView = findViewById<TextView>(R.id.results)
        textView.text = "Вы набрали ${results} баллов из 20"

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}