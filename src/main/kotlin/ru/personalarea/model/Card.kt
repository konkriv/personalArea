package ru.personalarea.model

interface Card {
    fun block(cardIds: List<Long>): Response<List<String>>
    fun unblock(cardIds: List<Long>): Response<List<String>>
}