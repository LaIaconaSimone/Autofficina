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
import com.example.autofficina.Adapter.InterventoAdapter

class FragmentInterventi : Fragment() {
    private lateinit var mInterventoViewModel: InterventoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_interventi, container, false)


        val button = view.findViewById<Button>(R.id.buttonAggiungiIntervento)
        button.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.container, FragmentAddIntervento())
                addToBackStack(null)
            }
        }


        val adapter = InterventoAdapter().apply {
            setOnItemClickListener { l -> Log.d("TAG", "$l") }
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.listViewInterventi)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Inizializza il ViewModel e osserva i dati
        mInterventoViewModel = ViewModelProvider(this).get(InterventoViewModel::class.java)
        mInterventoViewModel.getAllIntervento().observe(viewLifecycleOwner, Observer { intervento ->
            adapter.setDataIntervento(intervento)
        })
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentInterventi()
    }
}
