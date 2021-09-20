package ru.d3rvich.pizzaapp.domain.entity

class PizzaEntity(val id: Long, val price: Int)

class PizzaDetailEntity(
    val id: Long,
    val description: String,
    val composition: List<String>,
    val price: Int
)