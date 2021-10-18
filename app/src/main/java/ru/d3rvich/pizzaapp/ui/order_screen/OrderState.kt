package ru.d3rvich.pizzaapp.ui.order_screen

import ru.d3rvich.pizzaapp.ui.model.OrderItemUIModel

sealed class OrderState {
    object Idle : OrderState()
    object Loading : OrderState()
    object EmptyOrder : OrderState()
    class OrderList(val orderList: List<OrderItemUIModel>) : OrderState()
    class Error(val message: String) : OrderState()
}
