package ru.d3rvich.pizzaapp.ui.model

import androidx.annotation.DrawableRes

data class PizzaUIModel(
    val id: Long,
    val name: String,
    val price: String,
    val weight: String,
    @DrawableRes val photoResourceId: Int
)

// TODO: 05.10.2021 Добавить все необходимые поля
data class PizzaDetailUIModel(
    val id: Long
)