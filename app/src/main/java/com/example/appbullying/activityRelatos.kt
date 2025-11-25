package com.example.appbullying

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appbullying.R

class ActivityRelatos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telaprofessor)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerRelatos)

        val lista = listOf(
            Relato("Anônimo", "Subhead", "Relato", "Descrição do relato..."),
            Relato("Anônimo 2", "Subhead", "Outro Relato", "Mais uma descrição..."),
            Relato("Aluno X", "3ºA", "Confusão no pátio", "Relato completo...")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RelatoAdapter(lista)
    }
}
