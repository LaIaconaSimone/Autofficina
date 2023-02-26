package com.example.autofficina

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.autofficina.Adapter.SpinnerCliente
import com.example.autofficina.Adapter.SpinnerMacchina
import com.example.autofficina.Entity.Cliente
import com.example.autofficina.Entity.Intervento
import com.example.autofficina.Entity.Macchina


class FragmentAddIntervento : Fragment() {

    private lateinit var mInterventoViewModel: InterventoViewModel
    private lateinit var mMacchinaViewModel: MacchinaViewModel
    private lateinit var mMacchinaList: List<Macchina>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_intervento, container, false)
        mInterventoViewModel = ViewModelProvider(this).get(InterventoViewModel::class.java)
        mMacchinaViewModel = ViewModelProvider(this).get(MacchinaViewModel::class.java)
        mMacchinaViewModel.getAllMacchina().observe(viewLifecycleOwner, Observer {
            mMacchinaList = it
            val spinner = view.findViewById<Spinner>(R.id.spinnerIdMacchina)
            val adapter = SpinnerMacchina(requireContext(), mMacchinaList)
            spinner.adapter = adapter
        })
        val buttonSave = view.findViewById<Button>(R.id.buttonSave)

        buttonSave.setOnClickListener {
            insertDataToDatabase()
            requireActivity().onBackPressed()
        }
        return view
    }

    private fun insertDataToDatabase() {

        val idMacchinaSpinner = view?.findViewById<Spinner>(R.id.spinnerIdMacchina)
        val descrizioneEditText = view?.findViewById<EditText>(R.id.editTextDescrizione)
        val durataOrariaEditText = view?.findViewById<EditText>(R.id.editTextDurataOraria)
        val datatArrivoEditText = view?.findViewById<EditText>(R.id.editTextDataArrivo)
        val dataConsegnaEditText = view?.findViewById<EditText>(R.id.editTextDataConsegna)

        val idMacchinaSelezionata = idMacchinaSpinner?.selectedItem as Macchina

        val idMacchina = idMacchinaSelezionata.id
        val descrizione =descrizioneEditText?.text.toString()
        val durataOraria = durataOrariaEditText?.text.toString().toIntOrNull()?:0
        val dataArrivo = datatArrivoEditText?.text.toString()
        val dataConsegna = dataConsegnaEditText?.text.toString()

        val intervento = Intervento(0, idMacchina, descrizione, durataOraria, dataArrivo, dataConsegna)
        mInterventoViewModel.addIntervento(intervento)
        Toast.makeText(requireContext(), "Intervento aggiunto con successo", Toast.LENGTH_SHORT)
            .show()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentAddIntervento().apply {
                arguments = Bundle().apply {}
            }
    }
}