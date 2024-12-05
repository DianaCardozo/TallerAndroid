package com.example.applicationpokemon.services.driverAdapters

import com.example.applicationpokemon.services.controllers.ServiceList
import androidx.lifecycle.viewModelScope
import com.example.applicationpokemon.services.models.PokemonEntry

class AdapterList {
    private val service: ServiceList = ServiceList()

    fun allPokemonsByRegion(
        regionName: String,
        loadData: (list: List<PokemonEntry>) -> Unit,
        errorData: () -> Unit
    ) {
        this.service.getPokemonsByRegion(
            regionName = regionName,
            success = { loadData(it) },
            error = { errorData() }
        )
    }
}