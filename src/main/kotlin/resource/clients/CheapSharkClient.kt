package org.example.resource.clients

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class CheapSharkClient {

    fun getGameById(id: String): String{
        val httpClient: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$id"))
            .build()

        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }
}