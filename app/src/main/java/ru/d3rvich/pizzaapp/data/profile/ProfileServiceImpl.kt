package ru.d3rvich.pizzaapp.data.profile

import android.content.Context
import android.content.SharedPreferences
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.d3rvich.pizzaapp.data.dto.ProfileDto
import ru.d3rvich.pizzaapp.data.mappers.toProfileDto
import ru.d3rvich.pizzaapp.data.mappers.toProfileEntity
import ru.d3rvich.pizzaapp.domain.entity.ProfileEntity
import ru.d3rvich.pizzaapp.domain.profile.ProfileService
import javax.inject.Inject

private const val PROFILE_FILE_KEY = "profile_file_key"
private const val PROFILE_KEY = "profile_key"

class ProfileServiceImpl @Inject constructor(context: Context) : ProfileService {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PROFILE_FILE_KEY, Context.MODE_PRIVATE)

    override suspend fun getProfile(): ProfileEntity? {
        val jsonProfile: String? = sharedPreferences.getString(PROFILE_KEY, null)
        checkNotNull(jsonProfile) {
            return null
        }
        val profile: ProfileDto = Json.decodeFromString(jsonProfile)
        return profile.toProfileEntity()
    }

    override suspend fun updateProfile(profile: ProfileEntity) {
        with(sharedPreferences.edit()) {
            putString(PROFILE_KEY, Json.encodeToString(profile.toProfileDto()))
            apply()
        }
    }
}