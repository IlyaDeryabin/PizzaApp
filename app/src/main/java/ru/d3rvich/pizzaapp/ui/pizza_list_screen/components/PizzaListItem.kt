package ru.d3rvich.pizzaapp.ui.pizza_list_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel
import ru.d3rvich.pizzaapp.ui.theme.PizzaAppTheme

@Composable
fun PizzaListItem(pizzaItem: PizzaUIModel, onItemClick: () -> Unit, addToOrder: () -> Unit) {
    Box(
        Modifier
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .clickable { onItemClick() }
                .background(Color.LightGray)
                .padding(12.dp)) {
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(24.dp)),
                painter = painterResource(id = pizzaItem.photoResourceId),
                contentDescription = pizzaItem.name,
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier
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
                        text = "30 см",
                        color = Color.Black,
                        style = MaterialTheme.typography.body2
                    )
                    Text(
                        text = "${pizzaItem.weight} г",
                        color = Color.Black,
                        style = MaterialTheme.typography.body2
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = { addToOrder() },
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    Text(text = "${pizzaItem.price} р")
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
            "0",
            "Четыре сыра",
            "300",
            "100",
            R.drawable.four_cheeses
        )
        PizzaListItem(pizzaItem = pizzaEntity, onItemClick = {}, addToOrder = {})
    }
}