package com.example.myapplicationconxml

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSaludarApp = findViewById<Button>(R.id.btnSaludarApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnToDoAPP =findViewById<Button>(R.id.btnToDo)


        btnSaludarApp.setOnClickListener {
            navigateToSaludarApp()
        }

        btnIMCApp.setOnClickListener {
            navigateToCalculatorIMCApp()
        }

        btnToDoAPP.setOnClickListener {
            navigateToDoApp()
        }

    }

    private fun navigateToSaludarApp() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    private fun navigateToCalculatorIMCApp(){
        val intent = Intent(this, CalculatorIMC::class.java )
        startActivity(intent)
    }

    private fun navigateToDoApp(){
        val intent = Intent(this, ToDoActivity::class.java)
        startActivity(intent)

    }
}