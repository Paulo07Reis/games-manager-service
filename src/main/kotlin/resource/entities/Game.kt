package org.example.resource.entities

class Game(
    val title: String,
    val thumb: String,
    val description: String
) {
    override fun toString(): String {
        return "Game(title='$title', image='$thumb', description='$description')"
    }
}