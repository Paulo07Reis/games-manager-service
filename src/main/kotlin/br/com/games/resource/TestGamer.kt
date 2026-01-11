package org.example.br.com.games.resource

import org.example.br.com.games.resource.entities.Gamer

fun main(){
    val gamer = Gamer("   ", "paulo@gmail.com")

    val gamer2 = Gamer("Pedro", "pedro@gmail.com", "24/09/1975", "PJ")
    print(gamer2)

    //Scop function - let, run, with, apply and also
    gamer.let {
        it.birthday = "07/06/2004"
        it.user = "PR"
    }.also {
        print(gamer)
    }
}