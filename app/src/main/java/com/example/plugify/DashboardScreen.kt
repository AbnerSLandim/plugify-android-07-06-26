package com.example.plugify

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.plugify.RetrofitInstance
import com.example.plugify.model.Animal

@Composable
fun DashboardScreen() {

    var animais by remember {
        mutableStateOf<List<Animal>>(emptyList())
    }

    var carregando by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {

        try {
            animais = RetrofitInstance.api.listarAnimais()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            carregando = false
        }
    }

    val total = animais.size
    val ativos = animais.count { it.ativo }
    val inativos = animais.count { !it.ativo }

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

                if (carregando) {

                    Text("Carregando...")

                } else {

                    Text("Total de animais: $total")
                    Text("Animais ativos: $ativos")
                    Text("Animais inativos: $inativos")
                }
            }
        }
    }
}