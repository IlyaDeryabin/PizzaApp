package ru.d3rvich.pizzaapp.ui.pizza_detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
                .width(493.dp)
                .height(321.dp)
            Image(
                painter = painterResource(id = pizzaDetail.photoResourceId),
                contentDescription = "${pizzaDetail.name} photo",
                modifier = imageModifier,
                contentScale = ContentScale.Inside
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.
                padding(0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier
                        .width(26.666664123535156.dp)
                        .height(25.555557250976562.dp)
                        .clip(RoundedCornerShape(0.dp)),
                    painter = painterResource(id =R.drawable.ic_baseline_star_rate_24),
                    contentDescription = pizzaDetail.name,
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    modifier = Modifier
                        .width(26.666664123535156.dp)
                        .height(25.555557250976562.dp)
                        .clip(RoundedCornerShape(0.dp)),
                    painter = painterResource(id =R.drawable.ic_baseline_star_rate_24),
                    contentDescription = pizzaDetail.name,
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    modifier = Modifier
                        .width(26.666664123535156.dp)
                        .height(25.555557250976562.dp)
                        .clip(RoundedCornerShape(0.dp)),
                    painter = painterResource(id =R.drawable.ic_baseline_star_rate_24),
                    contentDescription = pizzaDetail.name,
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    modifier = Modifier
                        .width(26.666664123535156.dp)
                        .height(25.555557250976562.dp)
                        .clip(RoundedCornerShape(0.dp)),
                    painter = painterResource(id =R.drawable.ic_baseline_star_rate_24),
                    contentDescription = pizzaDetail.name,
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    modifier = Modifier
                        .width(26.666664123535156.dp)
                        .height(25.555557250976562.dp)
                        .clip(RoundedCornerShape(0.dp)),
                    painter = painterResource(id =R.drawable.ic_baseline_star_rate_24),
                    contentDescription = pizzaDetail.name,
                    contentScale = ContentScale.FillBounds
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = pizzaDetail.name,
                    textAlign = TextAlign.Start,
                    fontSize = 24.sp,
                    textDecoration = TextDecoration.None,
                    letterSpacing = 0.sp,

                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier

                        .width(183.dp)
                        .alpha(1f),
                    color = Color(red = 0.12941177189350128f, green = 0.12941177189350128f, blue = 0.12941177189350128f, alpha = 1f),
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Normal,
                )
                Text(
                    text = "${pizzaDetail.weight} г.",
                    textAlign = TextAlign.Start,
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.None,
                    letterSpacing = 0.sp,

                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(38.dp)
                        .alpha(1f),
                    color = Color(red = 0f, green = 0f, blue = 0f, alpha = 1f),
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Normal,
                )

            }
            Text(
                text = "Пицца 30 сантиметров, ${pizzaDetail.price} ₽,  250 ккал на 100 г  ",
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                textDecoration = TextDecoration.None,
                letterSpacing = 0.sp,

                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .width(257.dp)
                    .alpha(1f),
                color = Color(red = 0.12941177189350128f, green = 0.12941177189350128f, blue = 0.12941177189350128f, alpha = 1f),
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
            )
            pizzaDetail.composition.forEach { item ->
                Text(
                    modifier = Modifier.padding(start = 4.dp).width(331.dp)
                        .alpha(1f),
                    text = " $item ,",
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.None,
                    letterSpacing = 0.sp,
                    overflow = TextOverflow.Ellipsis,
                    color = Color(red = 0f, green = 0f, blue = 0f, alpha = 0.5f),
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                )
            }
        }
        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(CircleShape)
                .width(250.dp)
                .height(60.dp)
                .clip(RoundedCornerShape( 50.dp))
                .background(Color(red = 0.1882352977991104f, green = 0.1921568661928177f, blue = 0.4745098054409027f, alpha = 1f))
                .shadow(
                    elevation = 15.dp,
                    shape = RoundedCornerShape(10.dp),
                    clip = true
                ),
            onClick = { /*TODO*/ },
        ) {
            Text(
                text = "В корзину",
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                textDecoration = TextDecoration.None,
                letterSpacing = 0.sp,

                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .width(85.dp)
                    .alpha(1f),
                color = Color(red = 1f, green = 1f, blue = 1f, alpha = 1f),
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val pizzaDetail = PizzaDetailUIModel(
        id = "0",
        name = "Сырная",
        price = "490",
        weight = "520",
        composition = listOf(
            "Сыр моцарелла",
            "Соус сливочный",
            "Сыр Дор Блю",
            "Сыр Пармезан",
            "Оливковое масло"
        ),
        photoResourceId = R.drawable.cheesses
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
