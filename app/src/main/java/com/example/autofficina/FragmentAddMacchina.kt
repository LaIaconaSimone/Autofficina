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
import com.example.autofficina.Entity.Cliente
import com.example.autofficina.Entity.Macchina

class FragmentAddMacchina : Fragment() {

    private lateinit var mMacchinaViewModel: MacchinaViewModel
    private lateinit var mClienteViewModel: ClienteViewModel
    private lateinit var mClientiList: List<Cliente>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_macchina, container, false)
        mMacchinaViewModel = ViewModelProvider(this).get(MacchinaViewModel::class.java)
        mClienteViewModel = ViewModelProvider(this).get(ClienteViewModel::class.java)

        mClienteViewModel.getAllCliente().observe(viewLifecycleOwner, Observer {
            mClientiList = it
            val spinner = view.findViewById<Spinner>(R.id.spinnerIdCliente)
            val adapter = SpinnerCliente(requireContext(), mClientiList)
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

        val idClienteSpinner = view?.findViewById<Spinner>(R.id.spinnerIdCliente)
        val NumTelaioEditText = view?.findViewById<EditText>(R.id.editTextNumTelaio)
        val marcaEditText = view?.findViewById<EditText>(R.id.editTextMarca)
        val modelloEditText = view?.findViewById<EditText>(R.id.editTextModello)
        val targaEditText = view?.findViewById<EditText>(R.id.editTextTarga)

        val idClienteSelezionato = idClienteSpinner?.selectedItem as Cliente

        val idCliente = idClienteSelezionato.id
        val numTelaio = NumTelaioEditText?.text.toString()
        val marca = marcaEditText?.text.toString()
        val modello = modelloEditText?.text.toString()
        val targa = targaEditText?.text.toString()

        val macchina = Macchina(0, idCliente, numTelaio, marca, modello, targa)
        mMacchinaViewModel.addMacchina(macchina)
        Toast.makeText(requireContext(), "Macchina aggiunta con successo", Toast.LENGTH_SHORT)
            .show()
    }


    companion object {
    }
}