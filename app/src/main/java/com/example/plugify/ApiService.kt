package com.example.plugify

import com.example.plugify.model.Alerta
import com.example.plugify.model.Animal
import com.example.plugify.model.Leitura
import retrofit2.http.GET

interface ApiService {

    @GET("api/animais")
    suspend fun listarAnimais(): List<Animal>

    @GET("api/alertas")
    suspend fun listarAlertas(): List<Alerta>

    @GET("api/animais/{id}/leituras")
    suspend fun listarLeituras(
        @retrofit2.http.Path("id") id: Int
    ): List<Leitura>
}