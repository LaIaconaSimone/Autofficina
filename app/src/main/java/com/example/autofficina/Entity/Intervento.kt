package com.example.autofficina.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey


@Entity(
    tableName = "tabella_intervento",
    foreignKeys = [
        ForeignKey(
            entity = Macchina::class,
            parentColumns = ["id"],
            childColumns = ["macchina_id"],
            onDelete = CASCADE
        )]
)


data class Intervento(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val macchina_id: Long,
    val descrizione: String,
    val durataOraria: Int,
    val dataArrivo: String,
    val dataConsegna: String
)