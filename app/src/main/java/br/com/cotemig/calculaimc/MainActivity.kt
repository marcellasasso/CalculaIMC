package br.com.cotemig.calculaimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editTextPeso = findViewById<EditText>(R.id.editTextPeso)
        var editTextAltura = findViewById<EditText>(R.id.editTextAltura)
        var buttonCalcula = findViewById<Button>(R.id.buttonCalcula)

        buttonCalcula.setOnClickListener {
            calculaIMC(editTextPeso.text.toString().toDouble(), editTextAltura.text.toString().toDouble())
        }
    }

    fun calculaIMC(peso: Double, altura: Double) {

        var imc = peso / (altura * altura)

        var textViewIMC = findViewById<TextView>(R.id.textViewIMC)
        var textViewResultado = findViewById<TextView>(R.id.textViewResultado)

            // Abaixo de 17	Muito abaixo do peso
            // Entre 17 e 18,49	Abaixo do peso
            // Entre 18,50 e 24,99	Peso normal
            // Entre 25 e 29,99	Acima do peso
            // Entre 30 e 34,99	Obesidade I
            // Entre 35 e 39,99	Obesidade II (severa)
            // Acima de 40	Obesidade III (mórbida)

        if(imc >= 40) {
            textViewResultado.text = resources.getString(R.string.obesidade_III)
        } else if(imc >= 35) {
            textViewResultado.text = resources.getString(R.string.obesidade_II)
        } else if(imc >= 30) {
            textViewResultado.text = resources.getString(R.string.obesidade_I)
        } else if(imc >= 25) {
            textViewResultado.text = resources.getString(R.string.acima)
        } else if(imc >= 18.50) {
            textViewResultado.text = resources.getString(R.string.normal)
        } else if(imc >= 17) {
            textViewResultado.text = resources.getString(R.string.abaixo)
        } else {
            textViewResultado.text = resources.getString(R.string.muito_abaixo)
        }

        textViewIMC.text = resources.getString(R.string.imc, imc.toString())

    }
}