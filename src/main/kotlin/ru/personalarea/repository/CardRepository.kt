package ru.personalarea.repository

import org.springframework.data.repository.CrudRepository
import ru.personalarea.model.Card

interface CardRepository : CrudRepository<Card, Long> {

}