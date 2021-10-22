package ru.d3rvich.pizzaapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import ru.d3rvich.pizzaapp.ui.order_screen.OrderScreen
import ru.d3rvich.pizzaapp.ui.order_screen.OrderViewModel
import ru.d3rvich.pizzaapp.ui.pizza_list_screen.PizzaListScreen
import ru.d3rvich.pizzaapp.ui.pizza_list_screen.PizzaListViewModel
import ru.d3rvich.pizzaapp.ui.profile_screen.ProfileScreen
import ru.d3rvich.pizzaapp.ui.profile_screen.ProfileViewModel
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
                            val viewModel: PizzaListViewModel by viewModels()
                            PizzaListScreen(navController = navController, viewModel = viewModel)
                        }
                        composable(route = Screens.ProfileScreen.route) {
                            val viewModel: ProfileViewModel by viewModels()
                            ProfileScreen(navController = navController, viewModel = viewModel)
                        }
                        composable(route = Screens.PizzaDetailScreen.route + "/{$PIZZA_ID_KEY}") {
                            PizzaDetailScreen(navController = navController)
                        }
                        composable(route = Screens.OrderScreen.route) {
                            val viewModel: OrderViewModel by viewModels()
                            OrderScreen(viewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}