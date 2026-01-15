package org.example.br.com.games.resource.clients

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.br.com.games.resource.entities.Game
import org.example.br.com.games.resource.entities.GamerJson
import org.example.br.com.games.resource.entities.GamesInfo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner

class CheapSharkClient {
    val gson = Gson()
    val scanner = Scanner(System.`in`)

    fun getGameById(id: String) : Game? {
        var game: Game? = null
        val httpClient: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$id"))
            .build()

        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())

        val result = runCatching {
            val infoGame = gson.fromJson(response.body(),  GamesInfo::class.java)

            game = Game(infoGame.info.title, infoGame.info.thumb)
        }

        result.onFailure {
            println("Game not found, use other game_id")
        }

        result.onSuccess {
            println("You need add a description? Y/N")
            print("Response: ")
            val userResponse = scanner.nextLine()

            if (userResponse.equals("Y", ignoreCase = true)) {
                print("Insert the description: ")
                val description = scanner.nextLine()
                game?.description = description
            } else {
                game?.description = game.title
            }

            println("\n" + game)

            return game
        }

        return null
    }

    fun findGamers(): List<GamerJson> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val gamerType = object : TypeToken<List<GamerJson>>() {}.type
        return gson.fromJson(json, gamerType)
    }
}