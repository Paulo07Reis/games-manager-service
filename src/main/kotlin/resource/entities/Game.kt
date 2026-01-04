package org.example.resource.entities

data class Game(
    val title: String,
    val thumb: String
) {
    val description = ""

    override fun toString(): String {
        return "Select game:\n" +
                " Title: $title\n" +
                " Image: $thumb\n" +
                " Description: $description"
    }
}