package ru.d3rvich.pizzaapp.ui.mappers

import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.domain.entity.PizzaDetailEntity
import ru.d3rvich.pizzaapp.domain.entity.OrderItemEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity
import ru.d3rvich.pizzaapp.ui.model.PizzaDetailUIModel
import ru.d3rvich.pizzaapp.ui.model.OrderItemUIModel
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

fun PizzaDetailEntity.toPizzaUIModel(): PizzaDetailUIModel {
    return PizzaDetailUIModel(
        id = id,
        name = name,
        price = price,
        weight = weight,
        composition = composition,
        photoResourceId = R.drawable.four_cheeses
    )
}