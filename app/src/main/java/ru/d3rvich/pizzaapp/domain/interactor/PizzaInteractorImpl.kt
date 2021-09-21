package ru.d3rvich.pizzaapp.domain.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.d3rvich.pizzaapp.common.Resource
import ru.d3rvich.pizzaapp.domain.entity.PizzaDetailEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity
import ru.d3rvich.pizzaapp.domain.repository.PizzaRepository
import java.io.IOException
import javax.inject.Inject

class PizzaInteractorImpl @Inject constructor(private val repository: PizzaRepository) :
    PizzaInteractor {

    override fun getPizzaList(): Flow<Resource<List<PizzaEntity>>> = flow {
        try {
            emit(Resource.Loading())
            val pizzaList = repository.getPizzaList()
            emit(Resource.Success(pizzaList))
        } catch (e: HttpException) {
            emit(Resource.Error<List<PizzaEntity>>("Сервер не доступен"))
        } catch (e: IOException) {
            emit(Resource.Error<List<PizzaEntity>>("Нет подключения к интернету"))
        }
    }

    override fun getPizzaDetailBy(id: String): Flow<Resource<PizzaDetailEntity>> = flow {
        try {
            emit(Resource.Loading())
            val pizzaDetail = repository.getPizzaDetailBy(id)
            emit(Resource.Success(pizzaDetail))
        } catch (e: HttpException) {
            emit(Resource.Error<PizzaDetailEntity>("Сервер не доступен"))
        } catch (e: IOException) {
            emit(Resource.Error<PizzaDetailEntity>("Нет подключения к интернету"))
        }
    }
}