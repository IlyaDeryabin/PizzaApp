package ru.d3rvich.pizzaapp.domain.repository

import ru.d3rvich.pizzaapp.common.Resource
import ru.d3rvich.pizzaapp.domain.entity.PizzaDetailEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity

interface PizzaRepository {
    suspend fun getPizzaList(): Resource<List<PizzaEntity>>

    suspend fun getPizzaDetail(): Resource<PizzaDetailEntity>
}