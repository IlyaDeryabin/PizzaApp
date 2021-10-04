package ru.d3rvich.pizzaapp.ui.pizza_list_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel
import ru.d3rvich.pizzaapp.ui.theme.PizzaAppTheme

@ExperimentalMaterialApi
@Composable
fun PizzaListItem(pizzaItem: PizzaUIModel, onItemClick: () -> Unit) {
    Box(
        Modifier
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp)
    ) {
        Card(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            onClick = { onItemClick() },
            backgroundColor = Color.LightGray
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                Card(
                    modifier = Modifier.height(150.dp),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = pizzaItem.photoResourceId),
                        contentDescription = pizzaItem.name,
                        contentScale = ContentScale.FillBounds
                    )
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .height(100.dp)
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = pizzaItem.name,
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${pizzaItem.weight} г",
                            color = Color.Black,
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "${pizzaItem.price} руб",
                            color = Color.Black,
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun PizzaListItemPreview() {
    PizzaAppTheme {
        val pizzaEntity = PizzaUIModel(
            0,
            "Четыре сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        )
        PizzaListItem(pizzaItem = pizzaEntity, onItemClick = {})
    }
}