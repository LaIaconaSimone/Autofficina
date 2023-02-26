package com.example.autofficina

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.autofficina.Dao.ClienteDatabase
import com.example.autofficina.Entity.Cliente
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClienteViewModel(application: Application) : AndroidViewModel(application){
    val readAllData: LiveData<List<Cliente>>
    private val repository: ClienteRepository

    init {
        val clienteDao = ClienteDatabase.getDatabase(application).clienteDao()
        repository = ClienteRepository(clienteDao)
        readAllData = repository.getAllCliente
    }

    fun addCliente(cliente: Cliente) {
        viewModelScope.launch(Dispatchers.IO){
            repository.saveCliente(cliente)
        }
    }

    fun getAllCliente(): LiveData<List<Cliente>> {
        return repository.getAllCliente()
    }
}