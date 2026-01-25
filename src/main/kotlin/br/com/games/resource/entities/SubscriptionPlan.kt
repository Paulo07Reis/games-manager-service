package org.example.br.com.games.resource.entities

class SubscriptionPlan (
    type: String,
    val monthlyFee: Double,
    val gamesQuantity: Int
) : Plan(type)