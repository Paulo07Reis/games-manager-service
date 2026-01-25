package org.example.br.com.games.resource.entities

data class Plan(
    val type: String,
) {
    fun getValue(gamePrice: Double, rentTime: Int): Double {
        return gamePrice * rentTime
    }
}

