package com.example.autofficina

import androidx.lifecycle.LiveData
import com.example.autofficina.Dao.ClienteDao
import com.example.autofficina.Entity.Cliente

class ClienteRepository(private val clienteDao: ClienteDao) {
    val getAllCliente: LiveData<List<Cliente>> = clienteDao.getAllCliente()

    suspend fun saveCliente(cliente: Cliente) {
        clienteDao.save(cliente)
    }

    fun getAllCliente(): LiveData<List<Cliente>> {
        return getAllCliente
    }
}