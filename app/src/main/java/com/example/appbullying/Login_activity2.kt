package com.seuprojeto

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editRa = findViewById<EditText>(R.id.editRa)
        val editSenha = findViewById<EditText>(R.id.editSenha)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)

        btnEntrar.setOnClickListener {
            val raDigitado = editRa.text.toString().uppercase()
            val senhaDigitada = editSenha.text.toString()

            val prefs = getSharedPreferences("Cadastro", Context.MODE_PRIVATE)
            val raSalvo = prefs.getString("ra", "")
            val senhaSalva = prefs.getString("senha", "")
            val tipo = prefs.getString("tipo", "")

            if (raDigitado == raSalvo && senhaDigitada == senhaSalva) {
                Toast.makeText(this, "Login realizado!", Toast.LENGTH_SHORT).show()

                when (tipo) {
                    "aluno" -> startActivity(Intent(this, TelaAlunoActivity::class.java))
                    "professor" -> startActivity(Intent(this, TelaProfessorActivity::class.java))
                    else -> Toast.makeText(this, "Tipo de usuário desconhecido.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "RA/RG ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

