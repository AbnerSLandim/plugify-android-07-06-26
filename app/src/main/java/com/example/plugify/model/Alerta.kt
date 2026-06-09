package com.example.plugify.model

data class Alerta(
    val alertaId: Int,
    val tipo: String,
    val mensagem: String,
    val criadoEm: String,
    val resolvido: Boolean,
    val animalId: Int,
    val animalIdentificacao: String
)