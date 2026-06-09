package com.example.plugify

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.plugify.model.Alerta

@Composable
fun AlertasScreen() {

    var alertas by remember {
        mutableStateOf<List<Alerta>>(emptyList())
    }

    LaunchedEffect(Unit) {
        alertas = RetrofitInstance.api.listarAlertas()
    }

    LazyColumn {

        items(alertas) { alerta ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(alerta.tipo)

                    Text(alerta.mensagem)

                    Text(
                        "Animal: ${alerta.animalIdentificacao}"
                    )

                    Text(
                        if(alerta.resolvido)
                            "Resolvido"
                        else
                            "Pendente"
                    )
                }
            }
        }
    }
}