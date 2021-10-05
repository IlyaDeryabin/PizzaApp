package ru.d3rvich.pizzaapp.ui.pizza_list_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.ui.common.TopAppBar
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel
import ru.d3rvich.pizzaapp.ui.pizza_list_screen.components.PizzaListItem
import ru.d3rvich.pizzaapp.ui.theme.PizzaAppTheme

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun PizzaListScreen(viewModel: PizzaListViewModel) {
    when (val state = viewModel.uiState.value) {
        is PizzaListState.Idle -> {
        }
        is PizzaListState.Loading -> {
            Loading()
        }
        is PizzaListState.PizzaList -> {
            Scaffold(topBar = { TopAppBar(title = "PizzaApp", onProfilePressed = {}) }) {
                PizzaList(pizzaList = state.pizzaList)
            }
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

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun PizzaList(pizzaList: List<PizzaUIModel>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(bottom = 4.dp)
    ) {
        pizzaList.forEach { pizzaUIModel ->
            item {
                PizzaListItem(pizzaItem = pizzaUIModel) { // onItemClick
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

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun PizzaListPreview() {
    val pizzaList = List(10) {
        PizzaUIModel(
            0,
            "Четыре сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        )
    }
    PizzaAppTheme() {
        Scaffold(topBar = { TopAppBar(title = "PizzaApp", onProfilePressed = {}) }) {
            PizzaList(pizzaList = pizzaList)
        }
    }
}