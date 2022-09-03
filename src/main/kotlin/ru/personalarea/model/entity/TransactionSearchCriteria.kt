package ru.personalarea.model.entity

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDateTime

class TransactionSearchCriteria(
    @DateTimeFormat(iso = DATE_TIME)
    val dateTimeFrom: LocalDateTime,
    @DateTimeFormat(iso = DATE_TIME)
    val dateTimeTo: LocalDateTime = LocalDateTime.now(),
    val cardNumber: String?,
    val companyId: Int?


) {

}