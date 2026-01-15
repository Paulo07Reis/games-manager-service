package org.example

import org.example.br.com.games.resource.clients.CheapSharkClient

fun main(){
    val consume = CheapSharkClient()
    val listGamers = consume.findGamers()
    val gamerConsume = consume.getGameById("77")

    println(listGamers)
    println(gamerConsume)
}