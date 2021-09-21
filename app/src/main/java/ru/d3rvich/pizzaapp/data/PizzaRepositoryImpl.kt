package ru.d3rvich.pizzaapp.data

import ru.d3rvich.pizzaapp.domain.entity.PizzaDetailEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity
import ru.d3rvich.pizzaapp.domain.repository.PizzaRepository

class PizzaRepositoryImpl: PizzaRepository {
    override suspend fun getPizzaList(): List<PizzaEntity> {
        error("Not yet implemented")
    }

    override suspend fun getPizzaDetailBy(id: String): PizzaDetailEntity {
        error("Not yet implemented")
    }
}