package ru.d3rvich.pizzaapp.domain.entity

class PizzaEntity(
    val id: Long,
    val name: String,
    val price: String,
    val weight: String,
)

// TODO: 05.10.2021 Редактируй/добавляй поля, если считаешь это необходимым
class PizzaDetailEntity(
    val id: Long,
    val description: String,
    val composition: List<String>,
    val price: Int
)