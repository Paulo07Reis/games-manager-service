package org.example.br.com.games.resource.entities

import java.time.LocalDate
import java.time.Period

data class Period(
    val initialDate: LocalDate,
    val finalDate: LocalDate
){
    fun rentTime(): Int {
        return Period.between(initialDate, finalDate).days
    }
}
