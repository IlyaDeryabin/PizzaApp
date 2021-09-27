package ru.d3rvich.pizzaapp.ui

sealed class Screens(val route: String) {
    class PizzaListScreen: Screens("pizza_list")
    class PizzaDetailScreen: Screens("pizza_detail")
    class OrderScreen: Screens("order")
}
