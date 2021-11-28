package ru.d3rvich.pizzaapp.ui.pizza_list_screen.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel
import ru.d3rvich.pizzaapp.ui.theme.PizzaAppTheme

@Composable
fun PizzaListItem(pizzaItem: PizzaUIModel, onItemClick: () -> Unit, addToOrder: () -> Unit) {
    Box(
        Modifier
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp)
            .shadow(
                elevation = 15.dp,
                shape = RoundedCornerShape(10.dp),
                clip = true
            )

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .clickable { onItemClick() }
                .background(Color(red = 1f, green = 1f, blue = 1f, alpha = 1f))
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
                    .height(150.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = pizzaItem.name,
                        textAlign = TextAlign.Start,
                        fontSize = 18.sp,
                        textDecoration = TextDecoration.None,
                        letterSpacing = 0.sp,

                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier

                            .width(143.dp)
                            .alpha(1f),
                        color = Color(33,33,33),
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Normal,
                    )
                    Text(
                        text = "${pizzaItem.weight} гp.",
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

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Сыр моцарелла, Соус Сливочный, Сыр Пармезан, Сыр Дор Блю, Оливковое масло",
                    textAlign = TextAlign.Start,
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.None,
                    letterSpacing = 0.sp,

                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(215.dp)
                        .alpha(1f),
                    color = Color(red = 0f, green = 0f, blue = 0f, alpha = 0.5f),
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "30 см",
                        textAlign = TextAlign.Start,
                        fontSize = 13.sp,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .width(35.dp)
                            .alpha(1f),
                        color = Color(33,33,33),
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                    )
                    Text(
                        text = "490 ₽",
                        textAlign = TextAlign.Start,
                        fontSize = 13.sp,

                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .width(34.dp)
                            .alpha(1f),
                        color = Color(33,33,33),
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                    )
                    Image(
                        modifier = Modifier
                            .width(16.dp)
                            .height(15.333333969116211.dp)
                            .clip(RoundedCornerShape(0.dp)),
                        painter = painterResource(id =R.drawable.ic_baseline_star_rate_24),
                        contentDescription = pizzaItem.name,
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        modifier = Modifier
                            .width(16.dp)
                            .height(15.333333969116211.dp)
                            .clip(RoundedCornerShape(0.dp)),
                        painter = painterResource(id =R.drawable.ic_baseline_star_rate_24),
                        contentDescription = pizzaItem.name,
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        modifier = Modifier
                            .width(16.dp)
                            .height(15.333333969116211.dp)
                            .clip(RoundedCornerShape(0.dp)),
                        painter = painterResource(id =R.drawable.ic_baseline_star_rate_24),
                        contentDescription = pizzaItem.name,
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        modifier = Modifier
                            .width(16.dp)
                            .height(15.333333969116211.dp)
                            .clip(RoundedCornerShape(0.dp)),
                        painter = painterResource(id =R.drawable.ic_baseline_star_rate_24),
                        contentDescription = pizzaItem.name,
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                            modifier = Modifier
                                .width(16.dp)
                                .height(15.333333969116211.dp)
                                .clip(RoundedCornerShape(0.dp)),
                    painter = painterResource(id =R.drawable.ic_baseline_star_rate_24),
                    contentDescription = pizzaItem.name,
                    contentScale = ContentScale.FillBounds
                    )
                }
                Spacer(modifier = Modifier.height(0.dp))
                OutlinedButton(
                    onClick = { addToOrder() },
                    modifier = Modifier
                        .size(40.dp)
                        .align(End),
                    shape = CircleShape,
                    border = BorderStroke(1.dp, Color(48, 49, 121)),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(Color(48, 49, 121)),
                ) {
                    Text(text = "+",
                        fontSize = 25.sp,
                        color = Color(243,245,250),
                    )
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
            "Сырная",
            "300",
            "520",
            R.drawable.cheesses
        )
        PizzaListItem(pizzaItem = pizzaEntity, onItemClick = {}, addToOrder = {})
    }
}
