package com.example.autofficina

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.autofficina.Dao.ClienteDatabase
import com.example.autofficina.Entity.Intervento
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InterventoViewModel(application: Application) : AndroidViewModel(application){
    val readAllData: LiveData<List<Intervento>>
    private val repository: InterventoRepository

    init {
        val InterventoDao = ClienteDatabase.getDatabase(application).interventoDao()
        repository = InterventoRepository(InterventoDao)
        readAllData = repository.getAllIntervento
    }

    fun addIntervento(intervento: Intervento) {
        viewModelScope.launch(Dispatchers.IO){
            repository.saveIntervento(intervento)
        }
    }

    fun getAllIntervento(): LiveData<List<Intervento>> {
        return repository.getAllIntervento
    }
}