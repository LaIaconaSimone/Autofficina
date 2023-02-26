package com.example.autofficina

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.autofficina.Entity.Cliente

/*
class SecondFragment : Fragment() {

    private var nome: String? = null
    private var cognome: String? = null
    private var email: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val nomeEditText = view.findViewById<EditText>(R.id.editTextNome)
        val cognomeEditText = view.findViewById<EditText>(R.id.editTextCognome)
        val emailEditText = view.findViewById<EditText>(R.id.editTextEmail)
        val buttonSave = view.findViewById<Button>(R.id.buttonSave)
        buttonSave.setOnClickListener {
            nome = nomeEditText.text.toString()
            cognome = cognomeEditText.text.toString()
            email = emailEditText.text.toString()

            if (nome.isNullOrBlank() || cognome.isNullOrBlank() || email.isNullOrBlank()) {
                Toast.makeText(requireContext(), "Inserisci tutti i campi correttamente", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
        return view
    }

    companion object {
        @JvmStatic fun newInstance(param1: String, param2: String) =
                SecondFragment().apply {}
    }
}*/


class SecondFragment : Fragment() {

    private lateinit var mClienteViewModel: ClienteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        mClienteViewModel = ViewModelProvider(this).get(ClienteViewModel::class.java)
        val buttonSave = view.findViewById<Button>(R.id.buttonSave)

        buttonSave.setOnClickListener {
            insertDataToDatabase()
            requireActivity().onBackPressed()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val nomeEditText = view?.findViewById<EditText>(R.id.editTextNome)
        val cognomeEditText = view?.findViewById<EditText>(R.id.editTextCognome)
        val emailEditText = view?.findViewById<EditText>(R.id.editTextEmail)
        val nome = nomeEditText?.text.toString()
        val cognome = cognomeEditText?.text.toString()
        val email = emailEditText?.text.toString()

            val Cliente = Cliente(0, nome, cognome, email)
            mClienteViewModel.addCliente(Cliente)
            Toast.makeText(requireContext(), "Utente Registrato", Toast.LENGTH_LONG).show()
    }
}
