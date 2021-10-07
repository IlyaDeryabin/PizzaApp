package ru.d3rvich.pizzaapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.d3rvich.pizzaapp.data.PizzaRepositoryImpl
import ru.d3rvich.pizzaapp.data.profile.ProfileServiceImpl
import ru.d3rvich.pizzaapp.domain.profile.ProfileService
import ru.d3rvich.pizzaapp.domain.repository.PizzaRepository

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideRepository(): PizzaRepository {
        return PizzaRepositoryImpl()
    }

    @Provides
    fun provideProfileService(@ApplicationContext context: Context): ProfileService {
        return ProfileServiceImpl(context = context)
    }
}