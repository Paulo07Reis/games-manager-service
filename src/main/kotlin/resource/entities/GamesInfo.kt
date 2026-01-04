package org.example.resource.entities

class GamesInfo(
   val info: Game)
{
    override fun toString(): String {
        return info.toString()
    }
}