package ru.d3rvich.pizzaapp.ui.order_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.d3rvich.pizzaapp.common.Resource
import ru.d3rvich.pizzaapp.domain.entity.OrderItemEntity
import ru.d3rvich.pizzaapp.domain.interactor.PizzaInteractor
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(private val interactor: PizzaInteractor) : ViewModel() {

    private val _state = mutableStateOf<OrderState>(OrderState.Idle)
    val state: State<OrderState>
        get() = _state

    init {
        viewModelScope.launch {
            interactor.getOrderList().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.value = OrderState.Loading
                    }
                    is Resource.Success -> {
                        onSuccess(resource.data)
                    }
                    is Resource.Error -> {
                        _state.value = OrderState.Error("Ошибка во время загрузки")
                    }
                }
            }
        }
    }

    private fun onSuccess(orderList: List<OrderItemEntity>) {
        if (orderList.isEmpty()) {
            _state.value = OrderState.EmptyOrder
        } else {
            viewModelScope.launch {
                interactor.getPizzaList().collect {
                    _state.value = OrderState.OrderList(emptyList())
                }
            }
        }
    }
}