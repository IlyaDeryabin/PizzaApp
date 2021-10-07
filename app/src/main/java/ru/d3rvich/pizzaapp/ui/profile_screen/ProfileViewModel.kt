package ru.d3rvich.pizzaapp.ui.profile_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.d3rvich.pizzaapp.common.Resource
import ru.d3rvich.pizzaapp.domain.entity.ProfileEntity
import ru.d3rvich.pizzaapp.domain.interactor.PizzaInteractor
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(interactor: PizzaInteractor) : ViewModel() {

    private val _state = mutableStateOf<ProfileScreenState>(ProfileScreenState.Idle)
    val state: State<ProfileScreenState>
        get() = _state

    private var profile: ProfileEntity? = null

    init {
        viewModelScope.launch {
            interactor.getProfile().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.value = ProfileScreenState.Loading
                    }
                    is Resource.Success -> {
                        profile = resource.data
                        _state.value = ProfileScreenState.ProfileData(resource.data)
                    }
                    is Resource.Error -> {
                        val newProfile = ProfileEntity("", "", "", "")
                        profile = newProfile
                        _state.value = ProfileScreenState.Editor(newProfile, false)
                    }
                }
            }
        }
    }

    fun initializeProfileEditor() {
        if (profile !== null) {
            _state.value = ProfileScreenState.Editor(profile!!, true)
        } else {
            val newProfile = ProfileEntity("", "", "", "")
            _state.value = ProfileScreenState.Editor(newProfile, false)
        }
    }

    @Throws(Exception::class)
    fun cancelEditor() {
        if (profile == null) {
            error("Profile must be initialized")
        }
        _state.value = ProfileScreenState.ProfileData(profile!!)
    }

    fun updateProfile() {

    }
}