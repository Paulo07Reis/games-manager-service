package org.example.br.com.games.resource.entities

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

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("Name must not be blank")
        }
        this.email = emailValidator()
    }

}