package ru.d3rvich.pizzaapp.ui.order_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ru.d3rvich.pizzaapp.domain.entity.OrderItemEntity
import ru.d3rvich.pizzaapp.ui.order_screen.components.OrderListItem

@Composable
fun OrderScreen(viewModel: OrderViewModel) {
    when (val state = viewModel.state.value) {
        is OrderState.Idle -> {
        }
        is OrderState.Loading -> {

        }
        is OrderState.EmptyOrder -> {
            EmptyOrder()
        }
        is OrderState.OrderList -> {

        }
        is OrderState.Error -> {

        }
    }
}

@Composable
fun EmptyOrder() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Список пуст")
    }
}

@Composable
fun OrderList(orderList: List<OrderItemEntity>, viewModel: OrderViewModel) {
    orderList.forEach { item ->

    }
}