package com.example.plugify.model

data class Animal(
    val animalId: Int,
    val identificacao: String,
    val raca: String,
    val ativo: Boolean,
    val fazendaId: Int,
    val fazendaNome: String
)