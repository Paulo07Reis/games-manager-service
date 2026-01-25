package org.example.br.com.games.resource.entities

sealed class Plan(
    val type: String,
) {
    open fun getValue(rent: Rent): Double {
        return rent.game!!.price * rent.period.rentTime()
    }
}
