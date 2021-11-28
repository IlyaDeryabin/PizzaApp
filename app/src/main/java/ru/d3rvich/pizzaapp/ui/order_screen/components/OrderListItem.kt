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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.d3rvich.pizzaapp.R
import ru.d3rvich.pizzaapp.ui.model.OrderItemUIModel
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel

@Composable
fun OrderListItem(orderListItem: OrderItemUIModel) {
    var count by rememberSaveable {
        mutableStateOf(orderListItem.count)
    }
    val pizza: PizzaUIModel = orderListItem.pizzaUIModel
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(12.dp)
            .width(363.dp)
            .height(118.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(red = 1f, green = 1f, blue = 1f, alpha = 1f))
    ) {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .width(139.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(0.dp))
                .background(Color.Transparent),
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
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = pizza.name,
                        textAlign = TextAlign.Start,
                        fontSize = 18.sp,
                        textDecoration = TextDecoration.None,
                        letterSpacing = 0.sp,

                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .width(143.dp)
                            .alpha(1f),
                        color = Color(red = 0.12941177189350128f, green = 0.12941177189350128f, blue = 0.12941177189350128f, alpha = 1f),
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Normal,
                    )
                    Text(
                        text = "${pizza.weight} г.",
                        textAlign = TextAlign.Start,
                        fontSize = 9.sp,
                        textDecoration = TextDecoration.None,
                        letterSpacing = 0.sp,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .width(29.dp)
                            .alpha(1f),
                        color = Color(red = 0f, green = 0f, blue = 0f, alpha = 1f),
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Normal,
                    )
                }
                Text(
                    text = "30 см",
                    textAlign = TextAlign.Start,
                    fontSize = 13.sp,
                    textDecoration = TextDecoration.None,
                    letterSpacing = 0.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(35.dp)
                        .alpha(1f)
                        .padding(top=15.dp),
                    color = Color(red = 0.12941177189350128f, green = 0.12941177189350128f, blue = 0.12941177189350128f, alpha = 1f),
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                )
                Text(
                    text = "${pizza.price} ₽",
                    textAlign = TextAlign.Start,
                    fontSize = 13.sp,
                    textDecoration = TextDecoration.None,
                    letterSpacing = 0.sp,

                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(34.dp)
                        .alpha(1f)
                        .padding(top=15.dp),
                    color = Color(red = 0.12941177189350128f, green = 0.12941177189350128f, blue = 0.12941177189350128f, alpha = 1f),
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                )
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
    val pizza = PizzaUIModel(
        "0",
        "Сырная",
        "300",
        "100",
        R.drawable.cheesses
    )
    val orderListItem = OrderItemUIModel(pizza, 1)
    Surface {
        OrderListItem(orderListItem = orderListItem)
    }
}
