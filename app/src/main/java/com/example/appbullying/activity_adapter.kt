package com.example.appbullying

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RelatoAdapter(
    private val listaRelatos: List<Relato>
) : RecyclerView.Adapter<RelatoAdapter.RelatoViewHolder>() {

    class RelatoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome = itemView.findViewById<TextView>(R.id.txtNome)
        val subhead = itemView.findViewById<TextView>(R.id.txtSubhead)
        val titulo = itemView.findViewById<TextView>(R.id.txtTitulo)
        val descricao = itemView.findViewById<TextView>(R.id.txtDescricao)
        val btnDescricao = itemView.findViewById<Button>(R.id.btnDescricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reports, parent, false)
        return RelatoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RelatoViewHolder, position: Int) {
        val relato = listaRelatos[position]

        holder.nome.text = relato.nome
        holder.subhead.text = relato.subhead
        holder.titulo.text = relato.titulo
        holder.descricao.text = relato.descricao

        holder.btnDescricao.setOnClickListener {
            holder.descricao.visibility =
                if (holder.descricao.visibility == View.GONE) View.VISIBLE else View.GONE
        }
    }

    override fun getItemCount(): Int = listaRelatos.size
}
