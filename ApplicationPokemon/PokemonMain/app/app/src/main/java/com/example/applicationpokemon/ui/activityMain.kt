package com.example.applicationpokemon.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ComponentActivity
import com.example.applicationpokemon.services.driverAdapters.AdapterRegion

class activityMain : ComponentActivity() {
    val AdapterRegion by lazy { AdapterRegion() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var regiones by remember { mutableStateOf<List<Region>>(emptyList()) }
            var LoadRegiones by remember { mutableStateOf<Boolean>(false) }
            if (!LoadRegiones) {
                this.AdapterRegion.allRegiones(
                    loadData = {
                        regiones = it
                        LoadRegiones = true
                    },
                    errorData = {
                        println("Error en el servicio")
                        LoadRegiones = true
                    }
                )
            }
            RegionesScreen(regiones = regiones,
                onClickRegion = { regionName -> goToPokemons(regionName) },
                irFavoritos = {goToFavoritos()})
        }
    }

    fun goToFavoritos(){
        val intent = Intent( this, ActivityFavorite::class.java)
        startActivity(intent)
    }
    fun goToPokemons(regionName: String) {
        val intent = Intent(this, ActivityRegion::class.java).apply {
            putExtra("region_name", regionName)
        }
        startActivity(intent)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun RegionesScreen(
        regiones: List<Region>,
        onClickRegion: (String) -> Unit,
        irFavoritos: () -> Unit
    ) {
        PokemonTheme {
            Scaffold(
                topBar = {
                    SmallTopAppBar(
                        title = { Text(text = stringResource(id = R.string.title_regiones)) },
                        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                    )
                }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(5.dp) // Espaciado interno adicional
                ){
                    Button(
                        onClick = irFavoritos,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text("Favoritos")
                    }
                    LazyColumn(
                        modifier = Modifier
                    ) {
                        items(
                            items = regiones,
                            key = { it.name }
                        ) { region ->
                            RegionItem(region = region, onClickRegion = onClickRegion)
                        }
                    }
                }

            }
        }
    }

    @Composable
    fun RegionItem(
        region: Region,
        onClickRegion: (String) -> Unit
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClickRegion(region.name) },
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = region.name.replaceFirstChar { it.uppercase() },
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = stringResource(id = R.string.go_to_Region),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }


    @Preview(showBackground = true, widthDp = 360)
    @Composable
    fun RegionesScreenPreview() {
        RegionesScreen(
            regiones = emptyList(),
            onClickRegion = {},
            irFavoritos = {}

        )
    }
}}