package com.seuprojeto

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.appbullying.R

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val editDia = findViewById<EditText>(R.id.editDIA)
        val editMes = findViewById<EditText>(R.id.editMÊS)
        val editAno = findViewById<EditText>(R.id.editANO)
        val editRa = findViewById<EditText>(R.id.editRARG)
        val editSenha = findViewById<EditText>(R.id.editSENHA)
        val editConfirmar = findViewById<EditText>(R.id.editCONFIRMARSENHA)
        val btnEntrar = findViewById<Button>(R.id.editENTRAR)

        btnEntrar.setOnClickListener {
            val dia = editDia.text.toString()
            val mes = editMes.text.toString()
            val ano = editAno.text.toString()
            val ra = editRa.text.toString().uppercase()
            val senha = editSenha.text.toString()
            val confirmar = editConfirmar.text.toString()

            if (senha != confirmar) {
                Toast.makeText(this, "As senhas não coincidem!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (dia.isEmpty() || mes.isEmpty() || ano.isEmpty() || ra.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Determinar tipo de usuário
            val tipo = when {
                ra.startsWith("RA") -> "aluno"
                ra.startsWith("RG") -> "professor"
                else -> "desconhecido"
            }

            // Salvar dados localmente
            val prefs = getSharedPreferences("Cadastro", Context.MODE_PRIVATE)
            val editor = prefs.edit()
            editor.putString("ra", ra)
            editor.putString("senha", senha)
            editor.putString("tipo", tipo)
            editor.apply()

            Toast.makeText(this, "Cadastro salvo com sucesso!", Toast.LENGTH_SHORT).show()

            // Ir para a tela de login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

