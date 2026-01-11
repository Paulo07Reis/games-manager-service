package org.example

import org.example.br.com.games.resource.clients.CheapSharkClient
import org.example.br.com.games.resource.entities.Gamer
import org.example.br.com.games.resource.utils.toAge
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val cheapShark = CheapSharkClient()
    var notEnd = ""

    val gamer = Gamer.createGamer(scanner)
    println("\nRegister done")
    println(gamer)
    println("Gamer age: " + gamer.birthday?.toAge())

    do {
        print("\nSet game id: ")

        val gameId = scanner.nextLine()

        gamer.sharedGames.add(cheapShark.getGameById(gameId))

        println("\n\nDo you need to share a new game? Y/N")
        print("Response: ")
        notEnd = scanner.nextLine()

    } while (notEnd.equals("Y", ignoreCase = true))

    println("\n" + gamer.sharedGames.toString())

    println("\nGames order by name: ")
    gamer.sharedGames.sortBy {
        it?.title
    }

    gamer.sharedGames.forEach {
        println("Title: " + it?.title)
    }

    val filteredGames = gamer.sharedGames.filter {
        it?.title?.contains("batman", true) ?: false
    }
    println("\nFiltered games: ")
    println(filteredGames)

    println("\nDo you need to remove a game? Y/N")
    print("Response: ")
    val choice = scanner.nextLine()
    if (choice.equals("Y", ignoreCase = true)) {
        print("Set the game position: ")
        val gamePosition = scanner.nextInt()
        gamer.sharedGames.removeAt(gamePosition - 1)

        print("\nNew List:")
        print("\n" + gamer.sharedGames.toString())
    }

}