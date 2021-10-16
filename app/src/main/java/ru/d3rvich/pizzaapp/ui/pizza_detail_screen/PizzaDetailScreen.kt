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
            PizzaDescription()
        }
        is PizzaDetailState.Error -> {
            Error(errorText = state.message)
        }
    }
}

@Composable
fun PizzaDescription() {
    val image = painterResource(id = R.drawable.four_cheeses)
    val typography = MaterialTheme.typography
    Column(
        modifier = Modifier.padding(16.dp).fillMaxHeight()
    ) {
        val imageModifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp))
        Image(painter = image, contentDescription = "", modifier = imageModifier, contentScale = ContentScale.Crop)
        Spacer(Modifier.height(16.dp))

        Text("Сырная",style = MaterialTheme.typography.h5,modifier = Modifier.padding(bottom = 2.dp))
        Text("610 г.",style = MaterialTheme.typography.body1,modifier = Modifier.padding(bottom = 7.dp))
        Text("Ингридиенты",style = MaterialTheme.typography.h6)
        Text("Сыр моцарелла, Соус сливочный, Сыр Дор Блю, Сыр Пармезан, Оливковое масло",style = MaterialTheme.typography.body1)
        Spacer(Modifier.height(400.dp))
        AddPizza()
    }
}

@Composable
private fun AddPizza(){
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
    PizzaDescription()
}
