package org.example.br.com.games.resource.clients

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.br.com.games.resource.entities.Game
import org.example.br.com.games.resource.entities.Gamer
import org.example.br.com.games.resource.entities.GamerJson
import org.example.br.com.games.resource.entities.GamesInfo
import org.example.br.com.games.resource.utils.toGamer
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner

class CheapSharkClient {
    val gson = Gson()
    val scanner = Scanner(System.`in`)

    fun getResponseByUrl(url: String): String{
        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun getGameById(id: String) : Game? {
        var game: Game? = null
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"


        val response = getResponseByUrl(url)

        val result = runCatching {
            val infoGame = gson.fromJson(response,  GamesInfo::class.java)

            game = Game(infoGame.info.title, infoGame.info.thumb, infoGame.cheapestPriceEver.price)
        }

        result.onFailure {
            println("Game not found, use other game_id")
        }

        result.onSuccess {
//            println("You need add a description? Y/N")
//            print("Response: ")
            val userResponse = "N"

            if (userResponse.equals("Y", ignoreCase = true)) {
                print("Insert the description: ")
                val description = scanner.nextLine()
                game?.description = description
            } else {
                game?.description = game.title
            }

            return game
        }

        return null
    }

    fun findGamers(): List<Gamer> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = getResponseByUrl(url)

        val gson = Gson()
        val gamerType = object : TypeToken<List<GamerJson>>() {}.type
        val gamerJsonList: List<GamerJson> = gson.fromJson(json, gamerType)

        val gamerList= gamerJsonList.map { g -> g.toGamer() }

        return gamerList
    }
}