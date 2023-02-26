package com.example.autofficina

import androidx.lifecycle.LiveData
import com.example.autofficina.Dao.InterventoDao
import com.example.autofficina.Entity.Intervento

class InterventoRepository(private val interventoDao: InterventoDao) {

    val getAllIntervento: LiveData<List<Intervento>> = interventoDao.getAllIntervento()

    suspend fun saveIntervento(intervento: Intervento) {
        interventoDao.save(intervento)
    }

    fun getAllMacchina(): LiveData<List<Intervento>> {
        return getAllIntervento
    }
}