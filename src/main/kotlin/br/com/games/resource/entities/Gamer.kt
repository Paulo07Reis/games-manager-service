package org.example.br.com.games.resource.entities

import java.time.Month
import java.util.Scanner
import kotlin.random.Random

data class Gamer(
    var name: String,
    var email: String
) {
    var user: String? = null
        set(value) {
            field = value
            if (userId.isNullOrBlank()) {
                buildUserId()
            }
        }

    var birthday: String? = null
    var userId: String? = null
        private set
    val sharedGames = mutableListOf<Game?>()
    val rentGames = mutableListOf<Rent>()
    var plan: Plan = SinglePlan("BRONZE")

    constructor(
        name: String,
        email: String,
        birthday: String,
        user: String
    ) : this(name, email) {
        this.birthday = birthday
        this.user = user
        buildUserId()
    }

    override fun toString(): String {
        return "Gamer: \n" +
                "User id=$userId\n" +
                "User=$user\n" +
                "Name=$name\n" +
                "Email=$email\n" +
                "Birthday=$birthday\n\n"
    }

    fun buildUserId() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)
        userId = "$user#$tag"
    }

    fun emailValidator(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)){
            return email
        } else {
            throw IllegalArgumentException("Invalid email format")
        }
    }

    fun gamesMonth(month: Month): List<Game> {
        val gameList = mutableListOf<Game>()

        for (rent in rentGames){
            if (rent.period.initialDate.month == month){
                rent.game?.let { gameList.add(it) }
            }
        }

        return gameList
    }

    fun rentGame(game: Game?, period: Period): Rent {
        val rent = Rent(this, game, period)
        rentGames.add(rent)
        return rent
    }

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("Name must not be blank")
        }
        this.email = emailValidator()
    }

    companion object {
        fun createGamer(sc: Scanner) : Gamer {
            println("Creating gamer!")

            print("Gamer Name: ")
            val name = sc.nextLine()

            print("Gamer email: ")
            val email = sc.nextLine()

            println("Do you need to do the complete onboarding? Y/N")
            print("Choise: ")
            val choice = sc.nextLine()

            if (choice.equals("Y", ignoreCase = true)) {
                print("Birthdate: ")
                val birthday = sc.nextLine()
                print("User name: ")
                val user = sc.nextLine()

                return Gamer(name, email, birthday, user)
            } else {
                return Gamer(name, email)
            }
        }
    }

}