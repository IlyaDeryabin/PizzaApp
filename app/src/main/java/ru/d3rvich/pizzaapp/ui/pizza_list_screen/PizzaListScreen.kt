package ru.d3rvich.pizzaapp.ui.pizza_list_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel
import ru.d3rvich.pizzaapp.ui.pizza_list_screen.components.PizzaListItem

@Composable
fun PizzaListScreen(viewModel: PizzaListViewModel) {
    when (val state = viewModel.uiState.value) {
        is PizzaListState.Idle -> {
        }
        is PizzaListState.Loading -> {
            Loading()
        }
        is PizzaListState.PizzaList -> {
            PizzaList(pizzaList = state.pizzaList)
        }
        is PizzaListState.Error -> {
            Error(errorText = state.message)
        }
    }
}

@Composable
fun Loading() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun PizzaList(pizzaList: List<PizzaUIModel>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        pizzaList.forEach { pizzaUIModel ->
            item {
                PizzaListItem(pizzaList = pizzaUIModel) {
                }
            }
        }
    }
}

@Composable
fun Error(errorText: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = errorText)
    }
}

@Preview(showBackground = true)
@Composable
fun PizzaListPreview() {
    val pizzaList = List(5) {
        PizzaUIModel(
            0,
            "Четыре сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        )
    }
    PizzaList(pizzaList = pizzaList)
}