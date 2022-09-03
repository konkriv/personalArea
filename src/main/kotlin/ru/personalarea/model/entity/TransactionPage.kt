package ru.personalarea.model.entity

import org.springframework.data.domain.Sort.Direction

class TransactionPage(
    val pageNumber: Int = 0,
    val pageSize: Int = 50,
    val sortDirection: Direction = Direction.DESC,
    val sortBy: String = "trTime"
) {

}