package ru.d3rvich.pizzaapp.ui.pizza_detail_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.d3rvich.pizzaapp.common.Resource
import ru.d3rvich.pizzaapp.domain.interactor.PizzaInteractor
import ru.d3rvich.pizzaapp.ui.mappers.toPizzaUIModel
import ru.d3rvich.pizzaapp.ui.model.PizzaDetailUIModel
import javax.inject.Inject

const val PIZZA_ID_KEY: String = "pizza_id"

@HiltViewModel
class PizzaDetailViewModel @Inject constructor(
    private val interactor: PizzaInteractor,
//    savedStateHandle: SavedStateHandle
) : ViewModel() {

//    private val _state = mutableStateOf<PizzaDetailState>(PizzaDetailState.Idle)
//    val state: State<PizzaDetailState>
//        get() = _state

    private val mPizzaId = MutableLiveData<String>()
    val pizzaId: LiveData<String> get() = mPizzaId

    private val mPizzaDetail = MutableLiveData<PizzaDetailUIModel>()
    val pizzaDetail: LiveData<PizzaDetailUIModel> get() = mPizzaDetail

    fun setPizzaId(pizzaId: String?) {
        pizzaId?.let {
            mPizzaId.value = pizzaId
        }
    }

    fun loadData() {
        viewModelScope.launch {
//            val id: String = checkNotNull(savedStateHandle.get(PIZZA_ID_KEY)) {
//                _state.value = PizzaDetailState.Error("id пиццы не был добавлен в backStackEntry")
//                return@launch
//            }
            interactor.getPizzaDetailBy(id = mPizzaId.value ?: "").collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
//                        _state.value = PizzaDetailState.Loading
                    }
                    is Resource.Success -> {
                        mPizzaDetail.postValue(resource.data.toPizzaUIModel())
//                        _state.value =
//                            PizzaDetailState.PizzaDetail(
//                                pizza = resource.data.toPizzaUIModel()
//                            )
                    }
                    is Resource.Error -> {
//                        _state.value = PizzaDetailState.Error("Ошибка при загрузке")
                    }
                }
            }
        }
    }
}