package org.example.br.com.games.resource.entities

import com.google.gson.annotations.SerializedName

data class GamerJson(
    @SerializedName(value = "nome")
    val name: String,
    val email: String,
    @SerializedName(value = "dataNascimento")
    val birthday: String,
    @SerializedName(value = "usuario")
    val username: String,
)
