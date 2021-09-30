package ru.d3rvich.pizzaapp.domain.entity

class PizzaEntity(
    val id: Long,
    val name: String,
    val price: String,
    val weight: String,
)

class PizzaDetailEntity(
    val id: Long,
    val description: String,
    val composition: List<String>,
    val price: Int
)