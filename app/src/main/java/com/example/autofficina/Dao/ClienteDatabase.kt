package com.example.autofficina.Dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.autofficina.Entity.Cliente
import com.example.autofficina.Entity.Intervento
import com.example.autofficina.Entity.Macchina


@Database(
    entities = [Cliente::class, Macchina::class, Intervento::class],
    version = 2,
    exportSchema = false
)

abstract class ClienteDatabase : RoomDatabase() {
    abstract fun clienteDao(): ClienteDao
    abstract fun macchinaDao(): MacchinaDao
    abstract fun interventoDao(): InterventoDao

    companion object {
        @Volatile
        private var INSTANCE: ClienteDatabase? = null

        fun getDatabase(context: Context): ClienteDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ClienteDatabase::class.java,
                    "cliente_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
