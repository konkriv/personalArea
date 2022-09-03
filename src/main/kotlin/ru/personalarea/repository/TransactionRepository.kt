package ru.personalarea.repository

import org.springframework.data.repository.CrudRepository
import ru.personalarea.model.entity.TransactionDto
import java.time.LocalDate
import java.time.LocalDateTime

interface TransactionRepository: CrudRepository <TransactionDto, Long> {
    fun findAllByCompanyIdAndCreatedAtBetween(companyId: Int, dateBegin: LocalDateTime, dateEnd: LocalDateTime) : List <TransactionDto>

    fun findAllByTrTimeBetween(dateBegin: LocalDateTime, dateEnd: LocalDateTime) : List <TransactionDto>
}