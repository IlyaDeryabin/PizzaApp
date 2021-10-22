package ru.d3rvich.pizzaapp.ui.pizza_detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.d3rvich.pizzaapp.common.Resource
import ru.d3rvich.pizzaapp.domain.interactor.PizzaInteractor
import ru.d3rvich.pizzaapp.ui.mappers.toPizzaUIModel
import javax.inject.Inject

const val PIZZA_ID_KEY: String = "pizza_id"

@HiltViewModel
class PizzaDetailViewModel @Inject constructor(
    private val interactor: PizzaInteractor,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _state = mutableStateOf<PizzaDetailState>(PizzaDetailState.Idle)
    val state: State<PizzaDetailState>
        get() = _state

    init {
        viewModelScope.launch {
            val id: String = checkNotNull(savedStateHandle.get(PIZZA_ID_KEY)) {
                _state.value = PizzaDetailState.Error("id пиццы не был добавлен в backStackEntry")
                return@launch
            }
            interactor.getPizzaDetailBy(id = id).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.value = PizzaDetailState.Loading
                    }
                    is Resource.Success -> {
                        _state.value =
                            PizzaDetailState.PizzaDetail(
                                pizza = resource.data.toPizzaUIModel()
                            )
                    }
                    is Resource.Error -> {
                        _state.value = PizzaDetailState.Error("Ошибка при загрузке")
                    }
                }
            }
        }
    }
}