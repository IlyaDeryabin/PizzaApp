package ru.d3rvich.pizzaapp.ui.pizza_detail_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.ui.common.Error
import ru.d3rvich.pizzaapp.ui.common.Loading
import ru.d3rvich.pizzaapp.ui.model.PizzaDetailUIModel

@Composable
fun PizzaDetailScreen(viewModel: PizzaDetailViewModel = hiltViewModel()) {
    when (val state = viewModel.state.value) {
        is PizzaDetailState.Idle -> { // stay empty
        }
        is PizzaDetailState.Loading -> {
            Loading()
        }
        is PizzaDetailState.PizzaDetail -> {
            PizzaDetail(pizzaDetail = state.pizza)
        }
        is PizzaDetailState.Error -> {
            Error(errorText = state.message)
        }
    }
}

@Composable
fun PizzaDetail(pizzaDetail: PizzaDetailUIModel) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight()
    ) {
        val imageModifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp))
        Image(
            painter = painterResource(id = pizzaDetail.photoResourceId),
            contentDescription = "${pizzaDetail.name} photo",
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(16.dp))

        Text(
            pizzaDetail.name,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 2.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "${pizzaDetail.price} руб.",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 7.dp)
            )
            Text(
                "${pizzaDetail.weight} г.",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 7.dp)
            )

        }
        Text("Ингридиенты", style = MaterialTheme.typography.h6)
        pizzaDetail.composition.forEach { item ->
            Text(
                "- $item",
                style = MaterialTheme.typography.body1
            )
        }
        Spacer(Modifier.height(400.dp))
        AddPizza()
    }
}

@Composable
private fun AddPizza() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 85.dp)
            .clip(shape = CircleShape)
            .border(
                BorderStroke(1.dp, Color.Blue)
            )
    ) {
        Button(
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
    PizzaDetail(pizzaDetail = pizzaDetail)
}
