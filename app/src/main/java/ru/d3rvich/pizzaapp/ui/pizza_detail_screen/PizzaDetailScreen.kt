package ru.d3rvich.pizzaapp.ui.pizza_detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.ui.Screens
import ru.d3rvich.pizzaapp.ui.common.Error
import ru.d3rvich.pizzaapp.ui.common.Loading
import ru.d3rvich.pizzaapp.ui.common.TopAppBar
import ru.d3rvich.pizzaapp.ui.model.PizzaDetailUIModel

@Composable
fun PizzaDetailScreen(
    navController: NavController,
    viewModel: PizzaDetailViewModel = hiltViewModel()
) {
    var title by remember {
        mutableStateOf("Pizza Detail")
    }
    Scaffold(modifier = Modifier
        .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = title,
                onBackPressed = { navController.popBackStack() },
                onProfilePressed = { navController.navigate(Screens.ProfileScreen.route) })
        }) {
        when (val state = viewModel.state.value) {
            is PizzaDetailState.Idle -> { // stay empty
            }
            is PizzaDetailState.Loading -> {
                Loading()
            }
            is PizzaDetailState.PizzaDetail -> {
                title = state.pizza.name
                PizzaDetail(pizzaDetail = state.pizza)
            }
            is PizzaDetailState.Error -> {
                Error(errorText = state.message)
            }
        }
    }
}

@Composable
fun PizzaDetail(pizzaDetail: PizzaDetailUIModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {
        Column {
            val imageModifier = Modifier
                .align(CenterHorizontally)
                .height(160.dp)
            Image(
                painter = painterResource(id = pizzaDetail.photoResourceId),
                contentDescription = "${pizzaDetail.name} photo",
                modifier = imageModifier,
                contentScale = ContentScale.Inside
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${pizzaDetail.price} руб.",
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "${pizzaDetail.weight} г.",
                    style = MaterialTheme.typography.body1
                )
            }
            Text(
                text = "Ингредиенты",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            pizzaDetail.composition.forEach { item ->
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "- $item",
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(CircleShape),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text("Добавить в корзину")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val pizzaDetail = PizzaDetailUIModel(
        id = "0",
        name = "Четыре пиццы",
        price = "300",
        weight = "610",
        composition = listOf(
            "Сыр моцарелла",
            "Соус сливочный",
            "Сыр Дор Блю",
            "Сыр Пармезан",
            "Оливковое масло"
        ),
        photoResourceId = R.drawable.four_cheeses
    )
    Scaffold(modifier = Modifier
        .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = pizzaDetail.name,
                onBackPressed = {},
                onProfilePressed = {})
        }) {
        PizzaDetail(pizzaDetail = pizzaDetail)
    }
}
