package com.example.applicationpokemon.dataBase.viewModels

import androidx.lifecycle.viewModelScope
import com.example.applicationpokemon.dataBase.entities.EntitiesPokemon
import com.example.applicationpokemon.dataBase.repository.RepositoryPokemon
import com.example.applicationpokemon.dataBase.ConexionDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class FavoritePokemon {
    private val repository: RepositoryPokemon

    init {
        val dao = ConexionDataBase.getDataBase(context).DaoPokemon()
        this.repository = RepositoryPokemon(dao)
    }

    fun loadPokemons(
        data: (pokemons: List<EntitiesPokemon) -> Unit){
        viewModelScope.launch(Dispatchers.Main){
            repository.getAll().get{
                data(it)
            }
        }
    }

    fun searchPokemon(id: Int, result: (pokemon:EntitiesPokemon)->Unit){
        viewModelScope.launch(Dispatchers.Main){
            repository.find(id).collect{
                result(it)
            }
        }
    }


    fun savePokemonFavorito(pokemon: EntitiesPokemon){
        viewModelScope.launch (Dispatchers.Main){
            repository.save(pokemon)
        }
    }

    fun deletePokemonFavorito(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(id)
        }
    }

}

