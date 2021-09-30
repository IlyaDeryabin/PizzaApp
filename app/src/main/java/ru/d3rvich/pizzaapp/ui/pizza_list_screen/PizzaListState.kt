package ru.d3rvich.pizzaapp.ui.pizza_list_screen

import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel

sealed class PizzaListState {
    object Idle: PizzaListState()
    object Loading: PizzaListState()
    class PizzaList(val pizzaList: List<PizzaUIModel>): PizzaListState()
    class Error(val message: String): PizzaListState()
}
