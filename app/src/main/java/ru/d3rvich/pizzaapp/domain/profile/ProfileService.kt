package ru.d3rvich.pizzaapp.domain.profile

import ru.d3rvich.pizzaapp.domain.entity.ProfileEntity

interface ProfileService {

    suspend fun getProfile(): ProfileEntity?

    suspend fun updateProfile(profile: ProfileEntity)
}