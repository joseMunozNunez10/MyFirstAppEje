package com.example.myapplicationconxml

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationconxml.CalculatorIMC.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnReCalculater: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resoult_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: 1.0
        initComponent()
        initUI(result)
        initListener()
    }

    private fun initListener() {
        btnReCalculater.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvIMC.text.toString()
        when(result){
            in 0.00..18.50->{
                tvResult.text = getString(R.string.bajo_peso)
                tvDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.51..24.99->{
                tvResult.text = getString(R.string.Peso_Normal)
                tvDescription.text = getString(R.string.description_peso_normal)
            }
            in 25.00..29.99->{
                tvResult.text = getString(R.string.sobre_peso)
                tvDescription.text = getString(R.string.description_sobre_peso)
            }
            in 30.00..99.00 -> {
                tvResult.text = getString(R.string.obesidad)
                tvDescription.text = getString(R.string.description_obesidad)
            }
            else -> {
                tvResult.text = getString(R.string.error)
                tvIMC.text =  getString(R.string.error)
                tvDescription.text =  getString(R.string.error)
            }
        }

    }

    private fun initComponent() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculater = findViewById(R.id.btnReCalculater)
    }
}