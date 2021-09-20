package ru.d3rvich.pizzaapp.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.d3rvich.pizzaapp.common.Resource
import ru.d3rvich.pizzaapp.domain.entity.PizzaDetailEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity

interface PizzaInteractor {
    fun getPizzaList(): Flow<Resource<List<PizzaEntity>>>

    fun getPizzaDetail(): Flow<Resource<PizzaDetailEntity>>
}