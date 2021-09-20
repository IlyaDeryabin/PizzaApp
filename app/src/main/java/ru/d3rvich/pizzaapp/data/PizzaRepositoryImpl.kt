package ru.d3rvich.pizzaapp.data

import ru.d3rvich.pizzaapp.common.Resource
import ru.d3rvich.pizzaapp.domain.entity.PizzaDetailEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity
import ru.d3rvich.pizzaapp.domain.repository.PizzaRepository

class PizzaRepositoryImpl: PizzaRepository {
    override suspend fun getPizzaList(): Resource<List<PizzaEntity>> {
        error("Not yet implemented")
    }

    override suspend fun getPizzaDetail(): Resource<PizzaDetailEntity> {
        error("Not yet implemented")
    }
}