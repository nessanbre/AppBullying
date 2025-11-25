package com.example.appbullying

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityFormularioAluno : AppCompatActivity() {

    // Componentes
    private lateinit var tvAnonimo: TextView
    private lateinit var tvDataHora: TextView
    private lateinit var etDescricao: EditText
    private lateinit var checkAnonimo: CheckBox
    private lateinit var checkComNome: CheckBox
    private lateinit var btnEnviar: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formularioaluno)

        // Ajuste automático das barras
        val rootView = findViewById<View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar componentes
        inicializarViews()

        // Controlar comportamento dos checkboxes
        configurarCheckboxes()

        // Clique do botão enviar
        btnEnviar.setOnClickListener {
            enviarFormulario()
        }
    }

    private fun inicializarViews() {
        tvAnonimo = findViewById(R.id.tvAnonimo)
        tvDataHora = findViewById(R.id.tvDataHora)
        etDescricao = findViewById(R.id.etDescricao)
        checkAnonimo = findViewById(R.id.checkAnonimo)
        checkComNome = findViewById(R.id.checkComNome)
        btnEnviar = findViewById(R.id.btnEnviar)
    }

    private fun configurarCheckboxes() {
        // Apenas um pode ser marcado
        checkAnonimo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkComNome.isChecked = false
            }
        }

        checkComNome.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkAnonimo.isChecked = false
            }
        }
    }

    private fun enviarFormulario() {
        val descricao = etDescricao.text.toString().trim()

        if (descricao.isEmpty()) {
            Toast.makeText(this, "Por favor, descreva o ocorrido.", Toast.LENGTH_SHORT).show()
            return
        }

        val tipoEnvio = if (checkAnonimo.isChecked) {
            "Enviado como Anônimo"
        } else {
            "Enviado com nome de usuário"
        }

        Toast.makeText(this, "Denúncia enviada!\n$tipoEnvio", Toast.LENGTH_LONG).show()

        // Limpa o campo após enviar
        etDescricao.text.clear()
    }
}
