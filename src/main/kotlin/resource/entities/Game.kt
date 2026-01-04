package org.example.resource.entities

class Game(
    val title: String,
    val image: String,
    val description: String
) {
    override fun toString(): String {
        return "Game(title='$title', image='$image', description='$description')"
    }
}