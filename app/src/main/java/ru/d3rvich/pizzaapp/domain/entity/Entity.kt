package ru.d3rvich.pizzaapp.domain.entity

data class PizzaEntity(
    val id: String,
    val name: String,
    val price: String,
    val weight: String,
)

data class PizzaDetailEntity(
    val id: String,
    val name: String,
    val composition: List<String>,
    val price: String,
    val weight: String
)

data class ProfileEntity(
    val name: String,
    val surname: String,
    val phoneNumber: String,
    val address: String
)

data class OrderEntity(
    val pizzaList: List<OrderItemEntity>,
    val costumer: ProfileEntity
)

class OrderItemEntity(
    val pizzaId: String,
    val count: Int
)
