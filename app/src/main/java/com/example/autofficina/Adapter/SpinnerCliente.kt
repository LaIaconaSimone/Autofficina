package com.example.autofficina.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.autofficina.Entity.Cliente
import com.example.autofficina.R

class SpinnerCliente(private val mContext: Context, private val mListCliente: List<Cliente>) :
    BaseAdapter() {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(mContext).inflate(R.layout.spinner_layout, parent, false)
            val cliente = mListCliente[position]
            val nomeTextView = view.findViewById<TextView>(R.id.cliente_nome)
            val cognomeTextView = view.findViewById<TextView>(R.id.cliente_cognome)
            nomeTextView.text = cliente.nome
            cognomeTextView.text = cliente.cognome
            return view
        }

    override fun getItem(position: Int): Any {
        return mListCliente[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return mListCliente.size
    }

    fun getSpinnerContext(): Context {
        return mContext
    }

    private class ViewHolder(val clienteNomeTextView: TextView, val clienteCognomeTextView: TextView)
}