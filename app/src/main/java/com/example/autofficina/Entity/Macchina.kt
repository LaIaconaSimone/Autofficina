package com.example.autofficina.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity( tableName = "tabella_macchina",
    foreignKeys = [
        ForeignKey(
            entity = Cliente::class,
            parentColumns = ["id"],
            childColumns = ["cliente_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class Macchina(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val cliente_id: Long,
    val numeroTelaio: String,
    val marca: String,
    val modello: String,
    val targa: String
)