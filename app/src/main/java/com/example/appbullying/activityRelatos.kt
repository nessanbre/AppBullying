package com.example.appbullying  // troque pelo seu pacote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityRelatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relatos)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerRelatos)

        // Cria uma lista de relatos (pode depois vir do banco, API, etc)
        val lista = listOf(
            Relato(
                nome = "Anônimo",
                subhead = "Subhead",
                titulo = "Relato",
                descricao = "Na tarde do dia 08/09, estava eu e meus amigos almoçando quando começaram a brigar e..."
            ),
            Relato(
                nome = "Anônimo",
                subhead = "Subhead",
                titulo = "Relato",
                descricao = "Durante o recreio, houve uma discussão que terminou em empurrões perto da quadra."
            ),
            Relato(
                nome = "Anônimo",
                subhead = "Subhead",
                titulo = "Relato",
                descricao = "Testando o RecyclerView para mostrar múltiplos relatos com botão de descrição."
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RelatoAdapter(lista)
    }
}
