package ru.d3rvich.pizzaapp.ui.pizza_detail_screen

import ru.d3rvich.pizzaapp.ui.model.PizzaDetailUIModel

sealed class PizzaDetailState {
    object Idle : PizzaDetailState()
    object Loading : PizzaDetailState()
    class PizzaDetail(val pizza: PizzaDetailUIModel) : PizzaDetailState()
    class Error(val message: String) : PizzaDetailState()
}
