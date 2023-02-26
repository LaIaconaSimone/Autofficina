package com.example.autofficina

import androidx.lifecycle.LiveData
import com.example.autofficina.Dao.MacchinaDao
import com.example.autofficina.Entity.Macchina

class MacchinaRepository(private val macchinaDao: MacchinaDao) {

    val getAllMacchina: LiveData<List<Macchina>> = macchinaDao.getAllMacchina()

    suspend fun saveMacchina(macchina: Macchina) {
        macchinaDao.save(macchina)
    }

    fun getAllMacchina(): LiveData<List<Macchina>> {
        return getAllMacchina
    }
}