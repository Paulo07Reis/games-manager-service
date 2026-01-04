package org.example.resource.entities

class Game {
    var title = ""
    var image = ""
    val description = ""

    override fun toString(): String {
        return "Game(title='$title', image='$image', description='$description')"
    }
}