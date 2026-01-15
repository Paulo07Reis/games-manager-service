package org.example.br.com.games.resource.utils

import org.example.br.com.games.resource.entities.Gamer
import org.example.br.com.games.resource.entities.GamerJson

fun GamerJson.toGamer(): Gamer {
    return  Gamer(this.name, this.email, this.birthday, this.username)
}