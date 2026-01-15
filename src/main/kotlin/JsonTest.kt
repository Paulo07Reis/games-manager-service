package org.example

import org.example.br.com.games.resource.clients.CheapSharkClient

fun main(){
    val consume = CheapSharkClient()
    val listGamers = consume.findGamers()

    println(listGamers)
}