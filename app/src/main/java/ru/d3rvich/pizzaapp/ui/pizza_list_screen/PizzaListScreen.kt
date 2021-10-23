package ru.d3rvich.pizzaapp.ui.pizza_list_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.ui.Screens
import ru.d3rvich.pizzaapp.ui.common.Loading
import ru.d3rvich.pizzaapp.ui.common.Error
import ru.d3rvich.pizzaapp.ui.common.TopAppBar
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel
import ru.d3rvich.pizzaapp.ui.pizza_list_screen.components.PizzaListItem
import ru.d3rvich.pizzaapp.ui.theme.PizzaAppTheme

@ExperimentalAnimationApi
@Composable
fun PizzaListScreen(navController: NavController, viewModel: PizzaListViewModel) {
    Scaffold(topBar = {
        TopAppBar(
            title = "PizzaApp",
            onProfilePressed = { navController.navigate(Screens.ProfileScreen.route) })
    }) {
        when (val state = viewModel.uiState.value) {
            is PizzaListState.Idle -> {
            }
            is PizzaListState.Loading -> {
                Loading()
            }
            is PizzaListState.PizzaList -> {
                var orderButtonState by remember {
                    mutableStateOf(false)
                }
                val orderButtonSize = 50.dp
                Box(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .padding(bottom = if (orderButtonState) orderButtonSize else 0.dp)
                    ) {
                        PizzaList(
                            pizzaList = state.pizzaList,
                            navController = navController,
                            addToOrder = { orderButtonState = true })
                    }
                    AnimatedVisibility(
                        visible = orderButtonState,
                        modifier = Modifier.align(Alignment.BottomCenter)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(orderButtonSize)
                                .background(Color.Transparent),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(
                                onClick = { navController.navigate(Screens.OrderScreen.route) }
                            ) {
                                Text(text = "Перейти в корзину")
                            }
                        }
                    }
                }
            }
            is PizzaListState.Error -> {
                Error(errorText = state.message)
            }
        }
    }
}

@Composable
fun PizzaList(
    pizzaList: List<PizzaUIModel>,
    navController: NavController? = null,
    addToOrder: () -> Unit
) {
    LazyColumn(contentPadding = PaddingValues(bottom = 4.dp)) {
        pizzaList.forEach { pizzaUIModel ->
            item {
                PizzaListItem(pizzaItem = pizzaUIModel, onItemClick = {
                    navController
                        ?.navigate(Screens.PizzaDetailScreen.route + "/${pizzaUIModel.id}")
                }, addToOrder = addToOrder)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PizzaListPreview() {
    val pizzaList = List(10) {
        PizzaUIModel(
            "0",
            "Четыре сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        )
    }
    PizzaAppTheme {
        Scaffold(topBar = { TopAppBar(title = "PizzaApp", onProfilePressed = {}) }) {
            PizzaList(pizzaList = pizzaList, addToOrder = {})
        }
    }
}