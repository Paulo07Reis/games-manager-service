package org.example

import org.example.br.com.games.resource.clients.CheapSharkClient
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val cheapShark = CheapSharkClient()

    print("Set game id: ")
    val gameId = scanner.nextLine()

    cheapShark.getGameById(gameId)
}