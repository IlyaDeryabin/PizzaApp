package ru.d3rvich.pizzaapp.domain.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.d3rvich.pizzaapp.common.Resource
import ru.d3rvich.pizzaapp.domain.entity.PizzaDetailEntity
import ru.d3rvich.pizzaapp.domain.entity.PizzaEntity
import ru.d3rvich.pizzaapp.domain.entity.ProfileEntity
import ru.d3rvich.pizzaapp.domain.profile.ProfileService
import ru.d3rvich.pizzaapp.domain.repository.PizzaRepository
import java.io.IOException
import javax.inject.Inject

class PizzaInteractorImpl @Inject constructor(
    private val repository: PizzaRepository,
    private val profileService: ProfileService
) : PizzaInteractor {

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

    override fun getProfile(): Flow<Resource<ProfileEntity>> = flow {
        emit(Resource.Loading())
        val profile = profileService.getProfile()
        if (profile !== null) {
            emit(Resource.Success(profile))
        } else {
            emit(Resource.Error<ProfileEntity>("Profile doesn't created"))
        }
    }

    override fun updateProfile(profile: ProfileEntity): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        profileService.updateProfile(profile = profile)
        emit(Resource.Success(Unit))
    }
}