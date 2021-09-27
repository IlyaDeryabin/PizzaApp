package ru.d3rvich.pizzaapp.ui.pizza_list_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel
import ru.d3rvich.pizzaapp.ui.theme.PizzaAppTheme

@Composable
fun PizzaListItem(pizzaList: PizzaUIModel, onItemClick: () -> Unit) {
    Box(
        Modifier
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clickable { onItemClick() },
            shape = RoundedCornerShape(24.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = pizzaList.photoResourceId),
                    contentDescription = pizzaList.name,
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    modifier = Modifier
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        )
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 20.dp)
                        .padding(top = 40.dp, bottom = 12.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = pizzaList.name,
                        style = MaterialTheme.typography.h5,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "${pizzaList.weight} г", color = Color.White)
                        Text(text = "${pizzaList.price} руб", color = Color.White)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PizzaListItemPreview() {
    PizzaAppTheme {
        val pizzaEntity = PizzaUIModel(
            0,
            "4 сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        )
        PizzaListItem(pizzaList = pizzaEntity, onItemClick = {})
    }
}