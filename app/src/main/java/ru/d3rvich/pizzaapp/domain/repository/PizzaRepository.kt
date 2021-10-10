package ru.d3rvich.pizzaapp.domain.repository

import ru.d3rvich.pizzaapp.domain.entity.OrderItemEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaDetailEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity

interface PizzaRepository {
    suspend fun getPizzaList(): List<PizzaEntity>

    suspend fun getPizzaDetailBy(id: String): PizzaDetailEntity

    suspend fun getOrderList(): List<OrderItemEntity>

    suspend fun updateOrderList(order: OrderItemEntity)
}