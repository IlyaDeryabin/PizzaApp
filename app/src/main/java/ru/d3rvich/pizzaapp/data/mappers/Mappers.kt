package ru.d3rvich.pizzaapp.data.mappers

import ru.d3rvich.pizzaapp.data.dto.ProfileDto
import ru.d3rvich.pizzaapp.domain.entity.ProfileEntity

fun ProfileEntity.toProfileDto(): ProfileDto {
    return ProfileDto(
        name = name,
        surname = surname,
        phoneNumber = phoneNumber,
        address = address
    )
}

fun ProfileDto.toProfileEntity(): ProfileEntity {
    return ProfileEntity(
        name = name,
        surname = surname,
        phoneNumber = phoneNumber,
        address = address
    )
}