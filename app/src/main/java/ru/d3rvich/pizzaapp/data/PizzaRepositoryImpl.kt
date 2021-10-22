package ru.d3rvich.pizzaapp.data

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.d3rvich.pizzaapp.data.dto.OrderItemDto
import ru.d3rvich.pizzaapp.data.mappers.toOrderItemDto
import ru.d3rvich.pizzaapp.data.mappers.toOrderItemEntity
import ru.d3rvich.pizzaapp.domain.entity.OrderItemEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaDetailEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity
import ru.d3rvich.pizzaapp.domain.repository.PizzaRepository
import javax.inject.Inject

private const val ORDER_FILE_KEY = "order_file_key"
private const val ORDER_KEY = "order_key"

class PizzaRepositoryImpl @Inject constructor(context: Context) : PizzaRepository {

    private val sharedPreferences =
        context.getSharedPreferences(ORDER_FILE_KEY, Context.MODE_PRIVATE)

    override suspend fun getPizzaList(): List<PizzaEntity> {
        val pizzaList = List(10) { id ->
            PizzaEntity(
                id.toString(),
                "Четыре сыра",
                "300",
                "100"
            )
        }
        return pizzaList
    }

    override suspend fun getPizzaDetailBy(id: String): PizzaDetailEntity {
        return PizzaDetailEntity(
            id = id,
            name = "Четыре пиццы",
            price = "300",
            weight = "610",
            composition = listOf(
                "Сыр моцарелла",
                "Соус сливочный",
                "Сыр Дор Блю",
                "Сыр Пармезан",
                "Оливковое масло"
            )
        )
    }

    override suspend fun getOrderList(): List<OrderItemEntity> {
        val jsonList = sharedPreferences.getString(ORDER_KEY, null) ?: return emptyList()
        val list: List<OrderItemDto> = Json.decodeFromString(jsonList)
        return list.map(OrderItemDto::toOrderItemEntity)
    }

    override suspend fun updateOrderList(order: OrderItemEntity) {
        val jsonOrders: String = sharedPreferences.getString(ORDER_KEY, null) ?: return
        val orders: MutableList<OrderItemDto> = Json.decodeFromString(jsonOrders)
        orders.add(order.toOrderItemDto())
        with(sharedPreferences.edit()) {
            putString(ORDER_KEY, Json.encodeToString(orders))
            apply()
        }
    }
}