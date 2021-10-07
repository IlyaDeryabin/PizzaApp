package ru.d3rvich.pizzaapp.ui.profile_screen

import ru.d3rvich.pizzaapp.domain.entity.ProfileEntity

sealed class ProfileScreenState {
    object Idle: ProfileScreenState()
    object Loading: ProfileScreenState()
    class ProfileData(val profile: ProfileEntity): ProfileScreenState()
    class Editor(val profile: ProfileEntity, val isProfileExists: Boolean): ProfileScreenState()
}