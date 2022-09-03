package ru.personalarea.controller

import org.springframework.data.domain.Page
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.personalarea.model.entity.TransactionDto
import ru.personalarea.model.entity.TransactionPage
import ru.personalarea.model.entity.TransactionSearchCriteria
import ru.personalarea.repository.TransactionRepository
import ru.personalarea.service.TransactionService
import java.time.LocalDateTime
import java.time.LocalDateTime.now


@RestController
class TransactionController(
    private val repo: TransactionRepository,
    private val transactionService: TransactionService
) {
    @PostMapping("/api/transactions", produces = ["application/json;charset=utf-8"])
    fun getTransactions(
        @RequestParam("dateBegin")
        dateBegin: LocalDateTime,
        @RequestParam("dateEnd")
        dateEnd: LocalDateTime
    ): List<TransactionDto> = repo.findAllByTrTimeBetween(dateBegin, dateEnd)


    @GetMapping("/client/{companyId}/transactions", produces = ["application/json;charset=utf-8"])
    fun getTransactionsByCompanyAndPeriod(
        @PathVariable
        companyId: Int,
        dateBeginParam: LocalDateTime?,
        dateEndParam: LocalDateTime?
    ): List<TransactionDto> {
        val dateBegin = dateBeginParam ?: now().minusDays(now().dayOfMonth.toLong())
        val dateEnd = now()

        return repo.findAllByCompanyIdAndCreatedAtBetween(companyId, dateBegin, dateEnd)
    }

    @GetMapping("/transactions", produces = ["application/json;charset=utf-8"])
    fun getTransactions(
        transactionPage: TransactionPage,
        transactionSearchCriteria: TransactionSearchCriteria
    ): ResponseEntity<Page<TransactionDto>> {
        val responseHeaders = HttpHeaders()
        responseHeaders.set("Access-Control-Allow-Origin", "http://localhost:3001")

        return ResponseEntity.ok().headers(responseHeaders).body(transactionService.getTransactions(transactionPage, transactionSearchCriteria))
    }


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