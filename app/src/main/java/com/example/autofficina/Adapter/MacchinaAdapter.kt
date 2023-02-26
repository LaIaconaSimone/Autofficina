package com.example.autofficina.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.autofficina.Entity.Macchina
import com.example.autofficina.R

class MacchinaAdapter() : RecyclerView.Adapter<MacchinaAdapter.MyViewHolder>(
) {

    private var macchinaList = emptyList<Macchina>()
    private lateinit var listener: (Macchina) -> Unit

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_item_macchina, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = macchinaList[position]
        holder.itemView.findViewById<TextView>(R.id.textViewCliente_id).text =
            currentItem.cliente_id.toString()
        holder.itemView.findViewById<TextView>(R.id.textViewNumeroTelaio).text =
            currentItem.numeroTelaio
        holder.itemView.findViewById<TextView>(R.id.textMarca).text = currentItem.marca
        holder.itemView.findViewById<TextView>(R.id.textModello).text = currentItem.modello
        holder.itemView.findViewById<TextView>(R.id.textTarga).text = currentItem.targa
        holder.itemView.setOnClickListener {
            if (::listener.isInitialized)
                listener(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return macchinaList.size
    }

    fun setDataMacchina(macchinaList: List<Macchina>) {
        this.macchinaList = macchinaList
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (Macchina) -> Unit) {
        this.listener = listener
    }
}