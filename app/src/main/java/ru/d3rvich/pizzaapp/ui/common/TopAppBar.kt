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

@Composable
fun TopAppBarWithAction(
    title: String,
    onBackPressed: (() -> Unit),
    action: @Composable () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onBackPressed() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back button"
                )
            }
        }, actions = {
            action()
        }
    )
}

@Preview
@Composable
fun HeaderPreview() {
    PizzaAppTheme {
        TopAppBar(title = "PizzaApp")
    }
}

@Preview
@Composable
fun HeaderPreviewWithProfile() {
    PizzaAppTheme {
        TopAppBar(title = "PizzaApp", onProfilePressed = {})
    }
}

@Preview
@Composable
fun AppBarWithButton() {
    PizzaAppTheme {
        TopAppBar(title = "PizzaApp", onBackPressed = {})
    }
}

@Preview
@Composable
fun AppBarWithButtonAndProfile() {
    PizzaAppTheme {
        TopAppBar(title = "PizzaApp", onBackPressed = {}, onProfilePressed = {})
    }
}