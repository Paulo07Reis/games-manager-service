package org.example.br.com.games.resource.entities

data class Game(
    val title: String,
    val thumb: String,
    val price: Double,
) {
    var description = ""

    override fun toString(): String {
        return "Select game:\n" +
                " Title: $title\n" +
                " Image: $thumb\n" +
                " Price: $price\n" +
                " Description: $description"
    }
}