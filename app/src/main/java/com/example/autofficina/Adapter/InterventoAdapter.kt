package com.example.autofficina.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.autofficina.Entity.Intervento
import com.example.autofficina.Entity.Macchina
import com.example.autofficina.R

class InterventoAdapter() : RecyclerView.Adapter<InterventoAdapter.MyViewHolder>(
) {
    private var interventoList = emptyList<Intervento>()
    private lateinit var listener: (Intervento) -> Unit

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterventoAdapter.MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_item_interventi, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = interventoList[position]
        holder.itemView.findViewById<TextView>(R.id.textViewMacchina_id).text =
            currentItem.macchina_id.toString()
        holder.itemView.findViewById<TextView>(R.id.textViewDescrizione).text =
            currentItem.descrizione
        holder.itemView.findViewById<TextView>(R.id.textViewdurataOraria).text= currentItem.durataOraria.toString()
        holder.itemView.findViewById<TextView>(R.id.textViewdataArrivo).text = currentItem.dataArrivo
        holder.itemView.findViewById<TextView>(R.id.textViewdataConsegna).text = currentItem.dataConsegna
        holder.itemView.setOnClickListener {
            if (::listener.isInitialized)
                listener(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return interventoList.size
    }

    fun setDataIntervento(interventoList: List<Intervento>) {
        this.interventoList = interventoList
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (Intervento) -> Unit) {
        this.listener = listener
    }
}