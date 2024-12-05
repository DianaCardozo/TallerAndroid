package com.example.applicationpokemon.services.driverAdapters
import com.example.applicationpokemon.services.controllers.ServicesRegion
import com.example.applicationpokemon.services.models.Region

class AdapterRegion {
    private val service: ServicesRegion = ServicesRegion()

    fun allRegiones(
        loadData: (list: List<Region>) -> Unit,
        errorData: () -> Unit
    ){
        this.service.getAllRegiones(
            success = {loadData(it)},
            error = {errorData()}
        )
    }
}