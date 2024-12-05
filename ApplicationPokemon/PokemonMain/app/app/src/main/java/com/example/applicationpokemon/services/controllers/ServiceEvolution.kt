package com.example.applicationpokemon.services.controllers

import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import com.example.applicationpokemon.services.endPoints.endPointEvolution
import com.example.applicationpokemon.services.models.EvolutionResponse
import kotlinx.coroutines.launch



class ServiceEvolution : ServiceBase (){
    fun getEvolutionChainById(
        pokemonID: Int,
        success: (evolutionChain: EvolutionResponse) -> Unit,
        error: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = getRetrofit()
                    .create(endPointEvolution::class.java)
                    .getEvolutionChain(pokemonID)

                val data = response.body()

                if (response.isSuccessful && data != null) {
                    success(data)
                } else {
                    println("Error en la respuesta: ${response.code()}")
                    error()
                }
            } catch (e: Exception) {
                println("Error en la conexión: ${e.message}")
                error()
            }
        }
    }
}