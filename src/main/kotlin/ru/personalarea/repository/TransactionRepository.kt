package ru.personalarea.repository

import org.springframework.data.repository.CrudRepository
import ru.personalarea.model.Transaction
import java.time.LocalDate
import java.time.LocalDateTime

interface TransactionRepository: CrudRepository <Transaction, Long> {
    fun findAllByCompanyIdAndCreatedAtBetween(companyId: Int, dateBegin: LocalDate, dateEnd: LocalDate) : List <Transaction>

    fun findAllByCreatedAtBetween(dateBegin: LocalDateTime, dateEnd: LocalDateTime) : List <Transaction>
}