package com.example.autofficina

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.autofficina.Dao.ClienteDatabase
import com.example.autofficina.Entity.Macchina
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MacchinaViewModel(application: Application) : AndroidViewModel(application){
    val readAllData: LiveData<List<Macchina>>
    private val repository: MacchinaRepository

    init {
        val MacchinaDao = ClienteDatabase.getDatabase(application).macchinaDao()
        repository = MacchinaRepository(MacchinaDao)
        readAllData = repository.getAllMacchina
    }

    fun addMacchina(macchina: Macchina) {
        viewModelScope.launch(Dispatchers.IO){
            repository.saveMacchina(macchina)
        }
    }

    fun getAllMacchina(): LiveData<List<Macchina>> {
        return repository.getAllMacchina()
    }
}