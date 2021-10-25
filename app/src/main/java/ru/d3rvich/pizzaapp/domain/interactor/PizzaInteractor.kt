package ru.d3rvich.pizzaapp.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.d3rvich.pizzaapp.common.Resource
import ru.d3rvich.pizzaapp.domain.entity.OrderItemEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaDetailEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity
import ru.d3rvich.pizzaapp.domain.entity.ProfileEntity

interface PizzaInteractor {
    fun getPizzaList(): Flow<Resource<List<PizzaEntity>>>

    fun getPizzaDetailBy(id: String): Flow<Resource<PizzaDetailEntity>>

    fun getProfile(): Flow<Resource<ProfileEntity>>

    fun updateProfile(profile: ProfileEntity): Flow<Resource<Unit>>

    fun getOrder(): Flow<Resource<List<OrderItemEntity>>>

    fun updateOrder(order: OrderItemEntity): Flow<Resource<Unit>>

    fun cleanOrder(): Flow<Resource<Unit>>
}