package ru.d3rvich.pizzaapp.ui.order_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.domain.entity.OrderItemEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity
import ru.d3rvich.pizzaapp.ui.mappers.toPizzaUIModel
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel

@Composable
fun OrderListItem(orderListItem: OrderItemEntity) {
    var count by rememberSaveable {
        mutableStateOf(orderListItem.count)
    }
    val pizza: PizzaUIModel = orderListItem.pizza.toPizzaUIModel()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
            .height(120.dp)
            .padding(12.dp)
    ) {
        Image(
            modifier = Modifier
                .weight(3f)
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp)),
            painter = painterResource(id = pizza.photoResourceId),
            contentDescription = "Pizza photo",
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .weight(7f)
                .fillMaxHeight()
        ) {
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = pizza.name, style = MaterialTheme.typography.h6)
                Text(text = pizza.price)
            }
            Count(
                modifier = Modifier.align(Alignment.BottomEnd),
                count = count,
                onRemoveButtonClicked = { count-- },
                onAddButtonClicked = { count++ })
        }
    }
}

@Composable
fun Count(
    modifier: Modifier = Modifier,
    count: Int,
    onRemoveButtonClicked: () -> Unit,
    onAddButtonClicked: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onRemoveButtonClicked() }) {
            Icon(
                painterResource(id = R.drawable.ic_remove_circle_24),
                contentDescription = "Remove pizza button"
            )
        }
        Text(text = count.toString(), style = MaterialTheme.typography.body1)
        IconButton(onClick = { onAddButtonClicked() }) {
            Icon(Icons.Rounded.AddCircle, contentDescription = "Add pizza button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderItemPreview() {
    val pizza = PizzaEntity(
        0,
        "Четыре сыра",
        "300",
        "100"
    )
    val orderListItem = OrderItemEntity(pizza, 1)
    Surface {
        OrderListItem(orderListItem = orderListItem)
    }
}