package com.example.autofficina.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.autofficina.Entity.Macchina

//Definizione interfaccia DAO
@Dao
interface MacchinaDao {


    // Il metodo save()  viene utilizzato per inserire un nuovo oggetto Macchina nel database
    @Insert
    fun save(macchina: Macchina)


    //Ottenere tutti gli oggetti Macchina presenti nel database
    @Query("SELECT * FROM tabella_macchina")
    //LiveData garantisce un aggiornamento reattivo dell'interfaccia utente
    fun getAllMacchina(): LiveData<List<Macchina>>


}
