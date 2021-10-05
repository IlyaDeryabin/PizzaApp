package ru.d3rvich.pizzaapp.ui.pizza_detail_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import ru.d3rvich.pizzaapp.ui.common.Error
import ru.d3rvich.pizzaapp.ui.common.Loading
import ru.d3rvich.pizzaapp.ui.model.PizzaDetailUIModel
import ru.d3rvich.pizzaapp.ui.theme.PizzaAppTheme

@Composable
fun PizzaDetailScreen(viewModel: PizzaDetailViewModel = hiltViewModel()) {
    when (val state = viewModel.state.value) {
        is PizzaDetailState.Idle -> { // stay empty
        }
        is PizzaDetailState.Loading -> {
            Loading()
        }
        is PizzaDetailState.PizzaDetail -> {
            // TODO: 05.10.2021 Вывести на экран подробную информацию
            Content(pizza = state.pizza)
        }
        is PizzaDetailState.Error -> {
            Error(errorText = state.message)
        }
    }
}

@Composable
fun Content(pizza: PizzaDetailUIModel) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = pizza.id)
    }
}

@Preview
@Composable
fun PizzaDetailPreview() {
    PizzaAppTheme {
        val pizza = PizzaDetailUIModel("1")
        Content(pizza = pizza)
    }
}
