package org.example

import org.example.br.com.games.resource.clients.CheapSharkClient
import org.example.br.com.games.resource.entities.Period
import java.time.LocalDate

fun main(){
    val consume = CheapSharkClient()

    val listGamers = consume.findGamers()
    val gamer = listGamers[3]

    val game1 = consume.getGameById("77")
    val game2 = consume.getGameById("13")

    val period = Period(LocalDate.now(), LocalDate.now().plusDays(7))
    val period2 = Period(LocalDate.now(), LocalDate.now().plusDays(14))

    val rent = gamer.rentGame(game1, period)
    val rent2 = gamer.rentGame(game2, period2)

    for (rent in gamer.rentGames){
        println(rent)
    }
}