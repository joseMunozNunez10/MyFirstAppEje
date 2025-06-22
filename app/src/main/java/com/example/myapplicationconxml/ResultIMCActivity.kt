package com.example.myapplicationconxml

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationconxml.CalculatorIMC.Companion.IMC_KEY
import java.text.DecimalFormat

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
        val df = DecimalFormat("#.##")
        tvIMC.text = df.format(result)

        when {
            result < 18.5 -> {
                tvResult.text = getString(R.string.bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.Amarillo_advertencia))
                tvDescription.text = getString(R.string.description_bajo_peso)
            }
            result < 25 -> {
                tvResult.text = getString(R.string.Peso_Normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.Verde_Saludable))
                tvDescription.text = getString(R.string.description_peso_normal)
            }
            result < 30 -> {
                tvResult.text = getString(R.string.sobre_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.Naranjo_Alerta))
                tvDescription.text = getString(R.string.description_sobre_peso)
            }
            else -> {
                tvResult.text = getString(R.string.obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.Rojo_Alerta))
                tvDescription.text = getString(R.string.description_obesidad)
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