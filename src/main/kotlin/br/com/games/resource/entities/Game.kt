package org.example.br.com.games.resource.entities

data class Game(
    val title: String,
    val thumb: String
) {
    var description = ""

    override fun toString(): String {
        return "Select game:\n" +
                " Title: $title\n" +
                " Image: $thumb\n" +
                " Description: $description"
    }
}