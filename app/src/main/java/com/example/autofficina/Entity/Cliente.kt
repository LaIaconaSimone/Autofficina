package com.example.autofficina.Entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

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




