package com.example.applicationpokemon.dataBase.dao

import androidx.room.Dao
import androidx.room.OnConflictStrategy
import androidx.room.Insert
import androidx.room.Query

import com.example.applicationpokemon.dataBase.entities.EntitiesPokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoPokemon {

    @Query("SELECT * FROM pokemons")
    fun getPokemons(): Flow<List<EntitiesPokemon>>

    @Query("SELECT * FROM pokemons WHERE id = :id")
    fun getPokemonById(id: Int): Flow<EntitiesPokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdatePokemon(vararg pokemon: EntitiesPokemon)

    @androidx.room.Query("DELETE FROM pokemons WHERE id = :id")
    suspend fun deletePokemonById(id: Int)
}