package ru.personalarea.controller

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.personalarea.model.Transaction
import ru.personalarea.repository.TransactionRepository
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*


@RestController
class TransactionController(
    private val repo: TransactionRepository
) {
    @PostMapping("/api/transactions", produces = ["application/json;charset=utf-8"],)
    fun getTransactions(
        @RequestParam("dateBegin")
        dateBegin: LocalDateTime,
        @RequestParam("dateEnd")
        dateEnd: LocalDateTime
    ): List<Transaction> = repo.findAllByCreatedAtBetween(dateBegin, dateEnd)



//    @GetMapping("/companies/{companyId}/transactions", produces = ["application/json;charset=utf-8"])
//    fun getTransactionByCompanyId(@PathVariable companyId: Int): List<Transaction> {
//        val result = repo.findAllByCompanyIdAndCreatedAtBetween(
//            companyId,
//            LocalDate.of(2021, 5, 1),
//            LocalDate.of(2021, 6, 1)
//        )
//        return result
//    }
//
//    @GetMapping("/transactions", produces = ["application/json;charset=utf-8"])
//    fun getCompanyById(): MutableIterable<Transaction> {
//        val result = repo.findAllById(listOf(12738255, 12738160))
//        return result
//    }
}