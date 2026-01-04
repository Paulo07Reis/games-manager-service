package org.example

import org.example.resource.clients.CheapSharkClient

fun main() {

    val cheapShark = CheapSharkClient()

    val gameId = "612"

    cheapShark.getGameById(gameId)
}