package com.example.plugify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.plugify.ui.theme.PlugifyTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PlugifyTheme {
                GadoApp()
            }
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: Int
) {
    DASHBOARD("Resumo", R.drawable.outline_dashboard_24),
    MAPA("Mapa", R.drawable.outline_file_map_24),
    ANIMAIS("Animais", R.drawable.outline_grass_24)
}

@Composable
fun GadoApp() {

    var currentDestination by rememberSaveable {
        mutableStateOf(AppDestinations.DASHBOARD)
    }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach { destination ->
                item(
                    selected = destination == currentDestination,
                    onClick = {
                        currentDestination = destination
                    },
                    icon = {
                        Icon(
                            painterResource(destination.icon),
                            contentDescription = destination.label
                        )
                    },
                    label = {
                        Text(destination.label)
                    }
                )
            }
        }
    ) {

        Scaffold { padding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {

                when (currentDestination) {

                    AppDestinations.DASHBOARD ->
                        DashboardScreen()

                    AppDestinations.MAPA ->
                        MapaScreen()

                    AppDestinations.ANIMAIS ->
                        AnimaisScreen()
                }
            }
        }
    }
}