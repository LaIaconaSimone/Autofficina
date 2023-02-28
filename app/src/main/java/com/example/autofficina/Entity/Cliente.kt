package com.example.autofficina.Entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val nome: String,
    val cognome: String,
    val email: String

)
//{
//@PrimaryKey(autoGenerate = true) var id: Long = 0

//}




