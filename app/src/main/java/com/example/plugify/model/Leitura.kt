package com.example.plugify.model

data class Leitura(
    val leituraId: Int,
    val latitude: Double,
    val longitude: Double,
    val status: String,
    val timestamp: String,
    val sensorId: Int,
    val sensorCodigo: String
)