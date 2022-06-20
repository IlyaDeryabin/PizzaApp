package ru.d3rvich.pizzaapp.ui.pizza_list_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.d3rvich.pizzaapp.common.Resource
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity
import ru.d3rvich.pizzaapp.domain.interactor.PizzaInteractor
import ru.d3rvich.pizzaapp.ui.mappers.toPizzaUIModel
import ru.d3rvich.pizzaapp.ui.model.PizzaUIModel
import javax.inject.Inject

@HiltViewModel
class PizzaListViewModel @Inject constructor(
    private val interactor: PizzaInteractor,
) : ViewModel() {

//    private val _uiState = mutableStateOf<PizzaListState>(PizzaListState.Idle)
//    val uiState: State<PizzaListState>
//        get() = _uiState

    private val mPizzaListLiveData = MutableLiveData<List<PizzaUIModel>>()
    val pizzaListLiveData: LiveData<List<PizzaUIModel>>
        get() = mPizzaListLiveData

    init {
        viewModelScope.launch {
            interactor.getPizzaList().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
//                        _uiState.value = PizzaListState.Loading
                    }
                    is Resource.Success -> {
                        mPizzaListLiveData.postValue(resource.data.map(PizzaEntity::toPizzaUIModel))
//                        _uiState.value =
//                            PizzaListState.PizzaList(
//                                pizzaList = resource.data.map(PizzaEntity::toPizzaUIModel)
//                            )
                    }
                    is Resource.Error -> {
//                        _uiState.value = PizzaListState.Error("")
                    }
                }
            }
        }
    }
}