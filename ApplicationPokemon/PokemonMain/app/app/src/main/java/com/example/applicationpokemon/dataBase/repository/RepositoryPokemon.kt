package com.example.applicationpokemon.dataBase.repository

import com.example.applicationpokemon.dataBase.dao.DaoPokemon
import com.example.applicationpokemon.dataBase.entities.EntitiesPokemon
import kotlinx.coroutines.flow.Flow

class RepositoryPokemon(private val pokemonDao: DaoPokemon) {

    fun getAll(): Flow<List<EntitiesPokemon>>{
        return this.pokemonDao.getAll()
    }

    fun find(id: Int): Flow<EntitiesPokemon>{
        return this.pokemonDao.find(id)
    }


    suspend fun save(pokemon: EntitiesPokemon){
        return this.pokemonDao.save(pokemon)
    }

    suspend fun delete(id: Int) {
        pokemonDao.delete(id)
    }
}