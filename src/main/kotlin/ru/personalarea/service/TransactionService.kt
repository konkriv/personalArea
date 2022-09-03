package ru.personalarea.service

import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import ru.personalarea.model.entity.TransactionDto
import ru.personalarea.model.entity.TransactionPage
import ru.personalarea.model.entity.TransactionSearchCriteria
import ru.personalarea.repository.TransactionCriteriaRepository
//import ru.personalarea.repository.TransactionCriteriaRepositoryJava
import ru.personalarea.repository.TransactionRepository

@Service
class TransactionService(
    private val transactionRepository: TransactionRepository,
    private val transactionCriteriaRepositoryJava: TransactionCriteriaRepository
) {

    fun getTransactions(transactionPage: TransactionPage,
                        transactionSearchCriteria: TransactionSearchCriteria
    ): Page<TransactionDto> {
        return transactionCriteriaRepositoryJava.findAllWithFilters(transactionPage, transactionSearchCriteria)
    }

    fun addTransaction(transaction: TransactionDto): TransactionDto {
        return transactionRepository.save(transaction)
    }

}