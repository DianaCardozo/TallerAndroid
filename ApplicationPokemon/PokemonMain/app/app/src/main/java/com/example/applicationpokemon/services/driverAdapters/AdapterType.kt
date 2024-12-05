package com.example.applicationpokemon.services.driverAdapters

import com.example.applicationpokemon.services.controllers.ServiceType
import com.example.applicationpokemon.services.models.TypeFiltro

class AdapterType {
    private val service = ServiceType()

    fun getAllTypes(
        loadData: (list: List<TypeFiltro>) -> Unit,
        errorData: () -> Unit
    ) {
        service.getPokemonTypes(
            success = { loadData(it) },
            error = { errorData() }
        )
        println(" Haz logrado algo ${loadData}")
    }
}