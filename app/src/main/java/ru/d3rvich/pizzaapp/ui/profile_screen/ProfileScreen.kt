package ru.d3rvich.pizzaapp.ui.profile_screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            ProfileEditor(profile = state.profile, viewModel = viewModel) {
                ru.d3rvich.pizzaapp.ui.common.TopAppBar(
                    title = "Редактирование",
                    onBackPressed = {
                        if (state.isProfileExists) {
                            viewModel.closeEditor()
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            ProfileFieldBlock(title = "Фамилия", drawLine = true) {
                Text(
                    text = profile.surname,
                    style = MaterialTheme.typography.body1
                )
            }
            ProfileFieldBlock(title = "Имя", drawLine = true) {
                Text(
                    text = profile.name,
                    style = MaterialTheme.typography.body1
                )
            }
            ProfileFieldBlock(title = "Телефон", drawLine = true) {
                Text(
                    text = profile.phoneNumber,
                    style = MaterialTheme.typography.body1
                )
            }
            ProfileFieldBlock(title = "Адрес доставки", drawLine = true) {
                Text(
                    text = profile.address,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Composable
fun ProfileEditor(
    profile: ProfileEntity,
    viewModel: ProfileViewModel,
    topAppBar: @Composable () -> Unit
) {
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
            Spacer(modifier = Modifier.height(8.dp))
            ProfileFieldBlock(title = "Фамилия") {
                TextField(
                    value = surname, onValueChange = { surname = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            ProfileFieldBlock(title = "Имя") {
                TextField(
                    value = name, onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            ProfileFieldBlock(title = "Телефон") {
                TextField(
                    value = phoneNumber, onValueChange = { phoneNumber = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            ProfileFieldBlock(title = "Адрес доставки") {
                TextField(
                    value = address, onValueChange = { address = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = { viewModel.closeEditor() }) {
                    Text(text = "Отмена")
                }
                Button(onClick = {
                    val newProfile = ProfileEntity(name, surname, phoneNumber, address)
                    try {
                        viewModel.updateProfile(newProfile)
                    } catch (e: Exception) {
                        Log.d("Profile screen", "An error while update user data")
                    }
                }) {
                    Text(text = "Сохранить")
                }
            }
        }
    }
}

@Composable
private fun ProfileFieldBlock(
    title: String,
    drawLine: Boolean = false,
    content: @Composable () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = title, style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))
        content()
    }
    if (drawLine) {
        Spacer(modifier = Modifier.height(4.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(12.dp))
    } else {
        Spacer(modifier = Modifier.height(16.dp))
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