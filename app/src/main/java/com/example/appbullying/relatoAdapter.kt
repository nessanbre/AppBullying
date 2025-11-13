package com.example.appbullying  // troque pelo seu pacote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RelatoAdapter(private val listaRelatos: List<Relato>) :
    RecyclerView.Adapter<RelatoAdapter.RelatoViewHolder>() {

    class RelatoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgAvatar: ImageView = itemView.findViewById(R.id.imgAvatar)
        val txtNome: TextView = itemView.findViewById(R.id.txtNome)
        val txtSubhead: TextView = itemView.findViewById(R.id.txtSubhead)
        val txtTitulo: TextView = itemView.findViewById(R.id.txtTitulo)
        val txtDescricao: TextView = itemView.findViewById(R.id.txtDescricao)
        val btnDescricao: Button = itemView.findViewById(R.id.btnDescricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_relatoformularioluno, parent, false)
        return RelatoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RelatoViewHolder, position: Int) {
        val relato = listaRelatos[position]
        holder.txtNome.text = relato.nome
        holder.txtSubhead.text = relato.subhead
        holder.txtTitulo.text = relato.titulo
        holder.txtDescricao.text = relato.descricao

        // Aqui você pode colocar ação no botão se quiser:
        holder.btnDescricao.setOnClickListener {
            // Exemplo: mostrar Toast, abrir outra tela, etc.
        }
    }

    override fun getItemCount(): Int = listaRelatos.size
}
