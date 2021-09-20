package ru.d3rvich.pizzaapp.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.d3rvich.pizzaapp.common.Resource
import ru.d3rvich.pizzaapp.domain.entity.PizzaDetailEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity

class PizzaInteractorImpl : PizzaInteractor {
    override fun getPizzaList(): Flow<Resource<List<PizzaEntity>>> {
        error("Not yet implemented")
    }

    override fun getPizzaDetail(): Flow<Resource<PizzaDetailEntity>> {
        error("Not yet implemented")
    }
}