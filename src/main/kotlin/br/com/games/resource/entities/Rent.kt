package org.example.br.com.games.resource.entities

data class Rent(
    val gamer: Gamer,
    val game: Game?,
    val period: Period,
    val rentValue: Double = game!!.price * period.rentTime()
){

    override fun toString(): String {
        return "${game!!.title} rent by ${gamer.name} for R$$rentValue"
    }
}
