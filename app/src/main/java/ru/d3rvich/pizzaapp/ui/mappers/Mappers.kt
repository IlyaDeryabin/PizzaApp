package ru.d3rvich.pizzaapp.ui.mappers

import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel

fun PizzaEntity.toPizzaUIModel(): PizzaUIModel {
    return PizzaUIModel(
        id,
        name,
        weight,
        price,
        R.drawable.four_cheeses
    )
}