package ru.d3rvich.pizzaapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.d3rvich.pizzaapp.ui.pizza_detail_screen.PIZZA_ID_KEY
import ru.d3rvich.pizzaapp.ui.pizza_detail_screen.PizzaDetailScreen
import ru.d3rvich.pizzaapp.ui.pizza_list_screen.PizzaListScreen
import ru.d3rvich.pizzaapp.ui.theme.PizzaAppTheme

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.PizzaListScreen.route
                    ) {
                        composable(route = Screens.PizzaListScreen.route) {
                            PizzaListScreen(navController = navController)
                        }
                        composable(route = Screens.PizzaDetailScreen.route + "/{$PIZZA_ID_KEY}") {
                            PizzaDetailScreen()
                        }
                    }
                }
            }
        }
    }
}