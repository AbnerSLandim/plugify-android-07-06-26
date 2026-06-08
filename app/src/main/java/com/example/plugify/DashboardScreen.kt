package com.example.plugify

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen() {

    val animais = AnimalRepository.animais

    val total = animais.size
    val dentro = animais.count { it.dentroDaArea }
    val fora = animais.count { !it.dentroDaArea }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            "Monitoramento de Animais",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        Card {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("Total de animais: $total")
                Text("Dentro da área: $dentro")
                Text("Fora da área: $fora")
            }
        }
    }
}