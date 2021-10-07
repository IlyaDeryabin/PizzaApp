package ru.d3rvich.pizzaapp.ui.profile_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.d3rvich.pizzaapp.domain.entity.ProfileEntity
import ru.d3rvich.pizzaapp.ui.common.TopAppBarWithAction

@Composable
fun ProfileScreen(navController: NavController, viewModel: ProfileViewModel) {
    when (val state = viewModel.state.value) {
        is ProfileScreenState.Idle -> {
        }
        is ProfileScreenState.Loading -> {
            Loading()
        }
        is ProfileScreenState.ProfileData -> {
            Profile(profile = state.profile) {
                TopAppBarWithAction(
                    title = "Профиль",
                    onBackPressed = { navController.popBackStack() }) {
                    IconButton(onClick = { viewModel.initializeProfileEditor() }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit profile")
                    }
                }
            }
        }
        is ProfileScreenState.Editor -> {
            ProfileEditor(profile = state.profile) {
                ru.d3rvich.pizzaapp.ui.common.TopAppBar(
                    title = "Редактирование",
                    onBackPressed = {
                        if (state.isProfileExists) {
                            viewModel.cancelEditor()
                        } else {
                            navController.popBackStack()
                        }
                    })
            }
        }
    }
}

@Composable
private fun Loading() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun Profile(
    profile: ProfileEntity,
    topAppBar: @Composable () -> Unit
) {
    Scaffold(topBar = {
        topAppBar()
    }) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            ProfileFieldBlock(title = "Фамилия") {
                Text(text = profile.surname)
            }
            ProfileFieldBlock(title = "Имя") {
                Text(text = profile.name)
            }
            ProfileFieldBlock(title = "Телефон") {
                Text(text = profile.phoneNumber)
            }
            ProfileFieldBlock(title = "Адрес доставки") {
                Text(text = profile.address)
            }
        }
    }
}

@Composable
fun ProfileEditor(profile: ProfileEntity, topAppBar: @Composable () -> Unit) {
    Scaffold(topBar = { topAppBar() }, modifier = Modifier.fillMaxSize()) {
        var surname by rememberSaveable() {
            mutableStateOf(profile.surname)
        }
        var name by rememberSaveable() {
            mutableStateOf(profile.name)
        }
        var phoneNumber by rememberSaveable() {
            mutableStateOf(profile.phoneNumber)
        }
        var address by rememberSaveable() {
            mutableStateOf(profile.address)
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            ProfileFieldBlock(title = "Фамилия") {
                TextField(value = surname, onValueChange = { surname = it })
            }
            ProfileFieldBlock(title = "Имя") {
                TextField(value = name, onValueChange = { name = it })
            }
            ProfileFieldBlock(title = "Телефон") {
                TextField(value = phoneNumber, onValueChange = { phoneNumber = it })
            }
            ProfileFieldBlock(title = "Адрес доставки") {
                TextField(value = address, onValueChange = { address = it })
            }
        }
    }
}

@Composable
private fun ProfileFieldBlock(title: String, content: @Composable () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = title, style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    val profile = ProfileEntity(
        "Иван",
        "Иванов",
        "08884302",
        "У чёрта на куличиках"
    )
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Profile(profile = profile) {
            TopAppBarWithAction(
                title = "Профиль",
                onBackPressed = { }) {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit profile")
                }
            }
        }
    }
}