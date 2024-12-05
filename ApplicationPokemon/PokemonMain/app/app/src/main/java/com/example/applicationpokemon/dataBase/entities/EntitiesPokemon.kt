package com.example.applicationpokemon.dataBase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "DatosPokemons")
data class EntitiesPokemon (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "ident") val ident: Int,
    @ColumnInfo(name = "height") val height: Int,
    @ColumnInfo(name = "weight") val weight: Int,
    @ColumnInfo(name = "imgUrl") val imgUrl: String
    ) : Serializable