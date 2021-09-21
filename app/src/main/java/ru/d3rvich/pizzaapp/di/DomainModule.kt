package ru.d3rvich.pizzaapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.d3rvich.pizzaapp.domain.interactor.PizzaInteractor
import ru.d3rvich.pizzaapp.domain.interactor.PizzaInteractorImpl
import ru.d3rvich.pizzaapp.domain.repository.PizzaRepository

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideInteractor(repository: PizzaRepository): PizzaInteractor {
        return PizzaInteractorImpl(repository)
    }
}