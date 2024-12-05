package com.example.applicationpokemon.services.controllers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.applicationpokemon.services.endPoints.endPointRegion
import com.example.applicationpokemon.services.models.Region

class ServicesRegion : ServiceBase() {
    fun getAllRegiones(
        success: (regiones: List<Region>) -> Unit,
        error: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = getRetrofit()
                    .create(endPointRegion::class.java)
                    .getAllRegiones()

                val data = response.body()
                if (response.isSuccessful && data != null) {
                    success(data.results)
                } else {
                    success(emptyList())
                }
            } catch (e: Exception) {
                println(e)
                error()
            }
        }
    }
}