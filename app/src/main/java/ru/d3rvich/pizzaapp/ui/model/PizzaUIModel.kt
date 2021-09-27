package ru.d3rvich.pizzaapp.ui.model

import androidx.annotation.DrawableRes

data class PizzaUIModel(
    val id: Long,
    val name: String,
    val price: String,
    val weight: String,
    @DrawableRes val photoResourceId: Int
)