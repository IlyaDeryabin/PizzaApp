package ru.d3rvich.pizzaapp.ui.model

import androidx.annotation.DrawableRes

data class PizzaUIModel(
    val id: Long,
    val name: String,
    val price: String,
    val weight: String,
    @DrawableRes val photoResourceId: Int
)

data class PizzaDetailUIModel(
    val id: String,
    val name: String,
    val price: String,
    val weight: String,
    val composition: List<String>,
    @DrawableRes val photoResourceId: Int
)