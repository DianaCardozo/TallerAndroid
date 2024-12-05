package com.example.applicationpokemon.services.controllers

import com.example.applicationpokemon.services.models.TypeFiltro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.applicationpokemon.services.endPoints.endPointType

class ServiceType : ServiceBase() {
    fun getPokemonTypes(
        success: (tipos: List<TypeFiltro>) -> Unit,
        error: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = getRetrofit()
                    .create(endPointType::class.java)
                    .getPokemonTypes()

                val data = response.body()
                if (response.isSuccessful && data != null) {
                    success(data.results)
                    println(data.count)
                    println(data.results)
                } else {
                    println("Error en la respuesta: ${response.errorBody()?.string()}")
                    error()
                }
            } catch (e: Exception) {
                println("Excepción: ${e.message}")
                error()
            }
        }
    }
}