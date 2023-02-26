package com.example.autofficina.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.autofficina.Entity.Macchina
import com.example.autofficina.R

class SpinnerMacchina(private val mContext: Context, private val mListMacchina: List<Macchina>) :
    BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(mContext).inflate(R.layout.spinner_layout_macchina, parent, false)
        val macchina = mListMacchina[position]
        val marcaTextView = view.findViewById<TextView>(R.id.marca)
        val modelloTextView = view.findViewById<TextView>(R.id.modello)
        marcaTextView.text = macchina.marca
        modelloTextView.text = macchina.modello
        return view
    }

    override fun getItem(position: Int): Any {
        return mListMacchina[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return mListMacchina.size
    }

    fun getSpinnerContext(): Context {
        return mContext
    }

    private class ViewHolder(val macchinaMarcaTextView: TextView, val macchinaModelloTextView: TextView)
}