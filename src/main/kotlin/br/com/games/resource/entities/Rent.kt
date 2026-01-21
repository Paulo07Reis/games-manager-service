package org.example.br.com.games.resource.entities

import java.time.LocalDate
import java.time.Period

data class Rent(
    val gamer: Gamer,
    val game: Game?,
    val initialDate: LocalDate,
    val finalDate: LocalDate,
    val rentValue: Double = game!!.price * Period.between(initialDate, finalDate).days
){

    override fun toString(): String {
        return "${game!!.title} rent by ${gamer.name} for R$:$rentValue"
    }
}
