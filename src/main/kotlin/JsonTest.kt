package org.example

import org.example.br.com.games.resource.clients.CheapSharkClient
import java.time.LocalDate

fun main(){
    val consume = CheapSharkClient()
    val listGamers = consume.findGamers()
    val game = consume.getGameById("77")
    val date = LocalDate.now()

//    println(listGamers)
//    println(gamerConsume)

    val gamer = listGamers[0]

    println(game)
    println(gamer)

    val rent = gamer.rentGame(game, date, date)
    println(rent)
}