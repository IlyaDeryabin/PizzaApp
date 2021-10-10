package ru.d3rvich.pizzaapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProfileDto(
    val name: String,
    val surname: String,
    val phoneNumber: String,
    val address: String
)

@Serializable
data class OrderItemDto(
    val pizzaId: String,
    val count: Int
)