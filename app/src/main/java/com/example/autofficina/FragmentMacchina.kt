package com.example.autofficina

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autofficina.Adapter.MacchinaAdapter

class FragmentMacchina : Fragment() {
    private lateinit var mMacchinaViewModel: MacchinaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_macchina, container, false)

        // Imposta l'azione del pulsante per aggiungere una nuova macchina
        val button = view.findViewById<Button>(R.id.buttonAggiungiMacchina)
        button.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.container, FragmentAddMacchina())
                addToBackStack(null)
            }
        }

        // Crea e imposta l'adapter per il RecyclerView
        val adapter = MacchinaAdapter().apply {
            setOnItemClickListener { l -> Log.d("TAG", "$l") }
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.listViewMacchina)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Inizializza il ViewModel e osserva i dati
        mMacchinaViewModel = ViewModelProvider(this).get(MacchinaViewModel::class.java)
        mMacchinaViewModel.getAllMacchina().observe(viewLifecycleOwner, Observer { macchina ->
            adapter.setDataMacchina(macchina)
        })

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentMacchina()
    }
}