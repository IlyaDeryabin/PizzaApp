package ru.d3rvich.pizzaapp.ui

sealed class Screens(val route: String) {
    object PizzaListScreen: Screens("pizza_list")
    object PizzaDetailScreen: Screens("pizza_detail")
    object OrderScreen: Screens("order")
}
