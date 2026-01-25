package org.example.br.com.games.resource.entities

class SubscriptionPlan (
    type: String,
    val monthlyFee: Double,
    val gamesQuantity: Int
) : Plan(type) {

    override fun getValue(rent: Rent) : Double {
        val gamesRentInTheMonth = rent.gamer.gamesMonth(rent.period.initialDate.month).size

        return if (gamesRentInTheMonth <= gamesQuantity - 1) {
            0.0
        } else {
            super.getValue(rent)
        }
    }
}