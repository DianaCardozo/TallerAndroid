package com.example.applicationpokemon.services.driverAdapters

import com.example.applicationpokemon.services.controllers.ServiceEvolution
import com.example.applicationpokemon.services.models.EvolutionResponse

class AdapterEvolution {
    private val service: ServiceEvolution = ServiceEvolution()

    fun getEvolutionChain(
        pokemonID: Int,
        loadData: (evolutionChain: EvolutionResponse) -> Unit,
        errorData: () -> Unit
    ) {
        this.service.getEvolutionChainById(
            pokemonID = pokemonID,
            success = { loadData(it) },
            error = { errorData() }
        )
    }
}