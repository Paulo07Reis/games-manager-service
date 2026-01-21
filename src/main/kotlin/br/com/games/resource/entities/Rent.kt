package org.example.br.com.games.resource.entities

data class Rent(
    val gamer: Gamer,
    val game: Game?
){

    override fun toString(): String {
        return "${game!!.title} rent by ${gamer.name}"
    }
}
