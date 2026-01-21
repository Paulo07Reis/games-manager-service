package org.example

import org.example.br.com.games.resource.clients.CheapSharkClient
import org.example.br.com.games.resource.entities.Period
import java.time.LocalDate

fun main(){
    val consume = CheapSharkClient()
    val listGamers = consume.findGamers()
    val game = consume.getGameById("18")
    val period = Period(LocalDate.now(), LocalDate.now().plusDays(7))

    val gamer = listGamers[0]

    val rent = gamer.rentGame(game, period)
    println(rent)
}