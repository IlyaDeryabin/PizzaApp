package ru.d3rvich.pizzaapp.ui.pizza_list_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel
import ru.d3rvich.pizzaapp.ui.pizza_list_screen.components.PizzaListItem

@Composable
fun PizzaListScreen(pizzaList: List<PizzaUIModel>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        pizzaList.forEach { pizzaUIModel ->
            item {
                PizzaListItem(pizzaList = pizzaUIModel) {
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PizzaListPreview() {
    val pizzaList = listOf(
        PizzaUIModel(
            0,
            "4 сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        ), PizzaUIModel(
            0,
            "4 сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        ), PizzaUIModel(
            0,
            "4 сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        ), PizzaUIModel(
            0,
            "4 сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        ), PizzaUIModel(
            0,
            "4 сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        ), PizzaUIModel(
            0,
            "4 сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        ), PizzaUIModel(
            0,
            "4 сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        )
    )
    PizzaListScreen(pizzaList = pizzaList)
}