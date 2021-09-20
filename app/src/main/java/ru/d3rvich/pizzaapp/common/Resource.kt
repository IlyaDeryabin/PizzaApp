package ru.d3rvich.pizzaapp.common

sealed class Resource<T> {
    class Loading<T>(val data: T? = null): Resource<T>()
    class Success<T>(val data: T): Resource<T>()
    class Error<T>(val message: String): Resource<T>()
}
