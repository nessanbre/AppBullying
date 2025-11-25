package com.example.appbullying

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.appbullying.ActivityFormularioAluno
import com.example.appbullying.ActivityRelatos
import com.example.appbullying.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)  // seu XML

        // Referências aos componentes do layout
        val editRa = findViewById<EditText>(R.id.editRa)
        val editSenha = findViewById<EditText>(R.id.editSenha)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)

        btnEntrar.setOnClickListener {

            val raDigitado = editRa.text.toString().uppercase()
            val senhaDigitada = editSenha.text.toString()

            // Buscar dados salvos
            val prefs = getSharedPreferences("Cadastro", Context.MODE_PRIVATE)
            val raSalvo = prefs.getString("ra", null)
            val senhaSalva = prefs.getString("senha", null)
            val tipo = prefs.getString("tipo", null)

            // Validação
            if (raDigitado == raSalvo && senhaDigitada == senhaSalva) {

                Toast.makeText(this, "Login realizado!", Toast.LENGTH_SHORT).show()

                when (tipo) {
                    "aluno" -> startActivity(Intent(this, ActivityFormularioAluno::class.java))
                    "professor" -> startActivity(Intent(this, ActivityRelatos::class.java))
                    else -> Toast.makeText(this, "Tipo de usuário desconhecido.", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "RA/RG ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
