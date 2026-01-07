package org.example.resource.clients

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import org.example.resource.entities.Game
import org.example.resource.entities.GamesInfo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class CheapSharkClient {
    val gson = Gson()

    fun getGameById(id: String){
        val httpClient: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$id"))
            .build()

        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())

        try {
            val infoGame = gson.fromJson(response.body(),  GamesInfo::class.java)

            val game = Game(infoGame.info.title, infoGame.info.thumb)

            println(game)

        } catch (ex: JsonSyntaxException){
            println("Game not found, use other game_id")
        }

    }
}