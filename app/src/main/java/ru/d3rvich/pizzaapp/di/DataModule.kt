package ru.d3rvich.pizzaapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.d3rvich.pizzaapp.data.PizzaRepositoryImpl
import ru.d3rvich.pizzaapp.domain.repository.PizzaRepository

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideRepository(): PizzaRepository {
        return PizzaRepositoryImpl()
    }
}