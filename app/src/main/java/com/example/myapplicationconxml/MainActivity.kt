package com.example.myapplicationconxml

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        val btnStar = findViewById<Button>(R.id.btnStar)
        val edText = findViewById<EditText>(R.id.edText)

        btnStar.setOnClickListener {
            val name = edText.text.toString()

            if (name.isNotEmpty()) {
                val intent = Intent(this, ResoultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor escribe tu nombre", Toast.LENGTH_SHORT).show()
            }
        }

    }

}