package com.example.autofficina.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.autofficina.Entity.Intervento

@Dao
interface InterventoDao {

    @Insert
    fun save(intervento: Intervento)


    @Query("SELECT * FROM tabella_intervento")
    fun getAllIntervento(): LiveData<List<Intervento>>
}