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
import com.example.plugify.model.Leitura

@Composable
fun LeiturasScreen() {

    var leituras by remember {
        mutableStateOf<List<Leitura>>(emptyList())
    }

    LaunchedEffect(Unit) {

        leituras =
            RetrofitInstance.api.listarLeituras(1)
    }

    LazyColumn {

        items(leituras) { leitura ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        "Lat: ${leitura.latitude}"
                    )

                    Text(
                        "Lon: ${leitura.longitude}"
                    )

                    Text(
                        leitura.status
                    )

                    Text(
                        leitura.timestamp
                    )
                }
            }
        }
    }
}