package com.example.autofficina

import android.os.Bundle
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
import com.example.autofficina.Adapter.ClienteAdapter
import com.example.autofficina.Entity.Cliente

class FirstFragment : Fragment() {
    //Dichiarazione della variabile "mClienteViewModel" che verrà
    // utilizzata per gestire i dati dei clienti.
    private lateinit var mClienteViewModel: ClienteViewModel

    //Metodo "onCreate" che viene chiamato quando il frammento viene creato
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    // Metodo "onCreateView" che viene chiamato per creare e inflare
    // la vista del frammento.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Mette la vista del fragment utilizzando il layout definito in "fragment_first.xml"
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        // Ottiene il pulsante "Aggiungi" dalla vista del fragment.
        val button = view.findViewById<Button>(R.id.buttonAggiungi)
        // Imposta un "Listener" sul pulsante "Aggiungi" per gestire il click.
        button.setOnClickListener {
            // Sostituisce questo frammento con un altro frammento
            // chiamato "SecondFragment" utilizzando "parentFragmentManager".
            parentFragmentManager.commit {
                replace(R.id.container, SecondFragment())
                // Aggiunge questo frammento allo "BackStack"
                // per tenere traccia della cronologia di navigazione.
                addToBackStack(null)
            }
        }
        // Crea un nuovo "ClienteAdapter" che verrà utilizzato per popolare la lista dei clienti.
        val adapter = ClienteAdapter()
        // Ottiene la "RecyclerView" dalla vista del fragment.
        val recyclerView = view.findViewById<RecyclerView>(R.id.listView)
        // Imposta l'adapter del "RecyclerView" utilizzando il "ClienteAdapter" creato in precedenza.
        recyclerView.adapter = adapter
        // Imposta il "LayoutManager" del "RecyclerView" utilizzando un "LinearLayoutManager".
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        // Ottiene un'istanza di "ClienteViewModel".
        mClienteViewModel = ViewModelProvider(this).get(ClienteViewModel::class.java)
        // Aggiunge un "Observer" alla variabile "readAllData" di "ClienteViewModel" per osservare i dati dei clienti.
        mClienteViewModel.readAllData.observe(viewLifecycleOwner, Observer { clienti ->
            // Utilizza il metodo "setData" del "ClienteAdapter" per popolare
            // la lista dei clienti con i dati ottenuti dal database.
            adapter.setData(clienti)
        })
        // Restituisce la vista del frammento.
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FirstFragment().apply {}
    }
}
