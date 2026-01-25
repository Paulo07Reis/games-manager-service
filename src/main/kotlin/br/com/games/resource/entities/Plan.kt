package org.example.br.com.games.resource.entities

open class Plan(
    val type: String,
) {
    fun getValue(gamePrice: Double, rentTime: Int): Double {
        return gamePrice * rentTime
    }
}
