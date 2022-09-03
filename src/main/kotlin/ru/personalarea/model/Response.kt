package ru.personalarea.model

class Response<T>(
    val status: String,
    val errors: List<String> = emptyList(),
    val data: T
)