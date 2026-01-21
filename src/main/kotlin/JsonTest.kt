package org.example

import org.example.br.com.games.resource.clients.CheapSharkClient

fun main(){
    val consume = CheapSharkClient()
    val listGamers = consume.findGamers()
    val game = consume.getGameById("77")

//    println(listGamers)
//    println(gamerConsume)

    val gamer = listGamers[0]

    println(game)
    println(gamer)

    val rent = gamer.rentGame(game)
    println(rent)
}