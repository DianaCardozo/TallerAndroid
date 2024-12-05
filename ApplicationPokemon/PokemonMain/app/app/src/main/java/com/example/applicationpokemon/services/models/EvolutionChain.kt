package com.example.applicationpokemon.services.models

class EvolutionChain(
    val species: EvolutionSpecies,
    val evolves_to: List<EvolutionChain>
)
