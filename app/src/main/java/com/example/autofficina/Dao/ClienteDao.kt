package com.example.autofficina.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.autofficina.Entity.Cliente
//Definizione interfaccia DAO
@Dao
interface ClienteDao {
    // Il metodo save()  viene utilizzato per inserire un nuovo oggetto Cliente nel database
    @Insert
    fun save(cliente: Cliente)

    //ottenere tutti gli oggetti Cliente presenti nel database
    @Query("SELECT * FROM cliente ")
    //LiveData garantisce un aggiornamento reattivo dell'interfaccia utente
    fun getAllCliente(): LiveData<List<Cliente>>
}