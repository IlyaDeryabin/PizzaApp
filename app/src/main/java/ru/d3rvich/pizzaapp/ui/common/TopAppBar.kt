package ru.d3rvich.pizzaapp.ui.common

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.d3rvich.pizzaapp.ui.theme.PizzaAppTheme

@Composable
fun TopAppBar(title: String, onProfilePressed: (() -> Unit)? = null) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            if (onProfilePressed != null) {
                IconButton(onClick = { onProfilePressed() }) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "")
                }
            }
        }
    )
}

@Composable
fun TopAppBar(title: String, onBackPressed: () -> Unit, onProfilePressed: (() -> Unit)? = null) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onBackPressed() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back button"
                )
            }
        },
        actions = {
            if (onProfilePressed != null) {
                IconButton(onClick = { onProfilePressed() }) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    PizzaAppTheme {
        Scaffold(topBar = { TopAppBar(title = "PizzaApp") }) {
        }
    }
}

@Preview
@Composable
fun AppBarWithButton() {
    PizzaAppTheme {
        Scaffold(topBar = { TopAppBar(title = "PizzaApp", onBackPressed = {}) }) {
        }
    }
}