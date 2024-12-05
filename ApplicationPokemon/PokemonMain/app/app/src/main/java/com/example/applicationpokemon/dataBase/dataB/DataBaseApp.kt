package com.example.applicationpokemon.dataBase.dataB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.applicationpokemon.dataBase.dao.DaoPokemon
import com.example.applicationpokemon.dataBase.dao.pokemonsDao
import com.example.applicationpokemon.dataBase.entities.EntitiesPokemon

 @Database (
    entities = [
    EntitiesPokemon::class
    ],
    version = 5
    )

    abstract class DataBaseApp: RoomDatabase() {
        abstract fun DaoPokemon(): DaoPokemon
    }
