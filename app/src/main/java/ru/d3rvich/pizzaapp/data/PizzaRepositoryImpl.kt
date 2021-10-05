package ru.d3rvich.pizzaapp.data

import ru.d3rvich.pizzaapp.domain.entity.PizzaDetailEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity
import ru.d3rvich.pizzaapp.domain.repository.PizzaRepository

class PizzaRepositoryImpl: PizzaRepository {
    override suspend fun getPizzaList(): List<PizzaEntity> {
        val pizzaList = List(10) {
            PizzaEntity(
                0,
                "Четыре сыра",
                "300",
                "100"
            )
        }
        return pizzaList
    }

    override suspend fun getPizzaDetailBy(id: String): PizzaDetailEntity {
        return PizzaDetailEntity(
            id = 0,
            description = "",
            composition = listOf(),
            price = 0
        )
    }
}