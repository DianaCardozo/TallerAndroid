package com.example.applicationpokemon.dataBase

import android.content.Context
import androidx.room.Room
import com.example.applicationpokemon.dataBase.dataB.DataBaseApp


class ConexionDataBase {

    companion object {
        @Volatile
        private var instanceDb: DataBaseApp? = null
        fun getDataBase(context: Context): DataBaseApp {
            if (instanceDb === null) {
                synchronized(this) {
                    instanceDb = buildDB(context)
                }
            }
            return instanceDb!!
        }

        private fun buildDB(context: Context): DataBaseApp {
            val dataBase = Room.databaseBuilder(
                context,
                DataBaseApp::class.java,
                "BaseDeDatosPokemon"
            )
                .fallbackToDestructiveMigration() // Destruye y recrea la base si hay un conflicto de versión
            return  dataBase.build()
        }
    }
}