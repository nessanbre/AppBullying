package com.example.appbullying

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Tela1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_activity)

        // Ligação dos componentes do XML
        val editRA = findViewById<EditText>(R.id.editRA)
        val editSenha = findViewById<EditText>(R.id.editSenha)
        val editConfirmarSenha = findViewById<EditText>(R.id.editConfirmarSenha)
        val buttonCadastrar = findViewById<Button>(R.id.buttonCadastrar)

        // Quando clicar no botão
        buttonCadastrar.setOnClickListener {
            val ra = editRA.text.toString().trim()
            val senha = editSenha.text.toString()
            val confirmarSenha = editConfirmarSenha.text.toString()

            when {
                ra.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty() -> {
                    Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                }
                senha != confirmarSenha -> {
                    Toast.makeText(this, "As senhas não coincidem.", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                    // Aqui depois você pode trocar de tela, salvar dados, etc.
                }
            }
        }
    }
}

