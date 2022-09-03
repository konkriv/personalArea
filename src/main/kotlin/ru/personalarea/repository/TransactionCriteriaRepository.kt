package ru.personalarea.repository

import org.springframework.data.domain.*
import org.springframework.stereotype.Repository
import ru.personalarea.model.entity.TransactionDto
import ru.personalarea.model.entity.TransactionPage
import ru.personalarea.model.entity.TransactionSearchCriteria
import java.time.LocalDateTime
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

@Repository
class TransactionCriteriaRepository(
    private val entityManager: EntityManager,
//    private val criteriaBuilder: CriteriaBuilder,
) {
    var criteriaBuilder: CriteriaBuilder = entityManager.criteriaBuilder


    fun findAllWithFilters(
        transactionPage: TransactionPage,
        transactionSearchCriteria: TransactionSearchCriteria
    ): Page<TransactionDto> {
        val criteriaQuery = criteriaBuilder.createQuery(
            TransactionDto::class.java
        )
        val transactionRoot = criteriaQuery.from(TransactionDto::class.java)
        val predicate = getPredicate(transactionSearchCriteria, transactionRoot)
        criteriaQuery.where(predicate)
        setOrder(transactionPage, criteriaQuery, transactionRoot)
        val typedQuery = entityManager.createQuery(criteriaQuery)
        typedQuery.firstResult = transactionPage.pageNumber * transactionPage.pageSize
        typedQuery.maxResults = transactionPage.pageSize
        val pageable = getPageable(transactionPage)
        val transactionsCount = getTransactionsCount(predicate)
        return PageImpl(typedQuery.resultList, pageable, transactionsCount)
    }


    private fun getPredicate(
        transactionSearchCriteria: TransactionSearchCriteria,
        transactionDtoRoot: Root<TransactionDto>
    ): Predicate {
        val predicates: MutableList<Predicate> = ArrayList()
        preparePredicates(transactionSearchCriteria, predicates, transactionDtoRoot)

        return criteriaBuilder.and(*predicates.toTypedArray())
    }

    private fun setOrder(
        transactionPage: TransactionPage,
        criteriaQuery: CriteriaQuery<TransactionDto>,
        transactionRoot: Root<TransactionDto>
    ) {
        if (transactionPage.sortDirection == Sort.Direction.ASC) {
            criteriaQuery.orderBy(criteriaBuilder.asc(transactionRoot.get<Any>(transactionPage.sortBy)))
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(transactionRoot.get<Any>(transactionPage.sortBy)))
        }
    }

    private fun getPageable(transactionPage: TransactionPage): Pageable {
        val sort = Sort.by(transactionPage.sortDirection, transactionPage.sortBy)
        return PageRequest.of(transactionPage.pageNumber, transactionPage.pageSize, sort)
    }

    private fun getTransactionsCount(predicate: Predicate): Long {
        val countQuery = criteriaBuilder.createQuery(Long::class.java)
        val countRoot = countQuery.from(TransactionDto::class.java)
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate)
        return entityManager.createQuery(countQuery).singleResult
    }

    private fun preparePredicates(
        transactionSearchCriteria: TransactionSearchCriteria,
        predicates: MutableList<Predicate>,
        transactionDtoRoot: Root<TransactionDto>
    ) {
        if (Objects.nonNull(transactionSearchCriteria.companyId)) {
            predicates.add(
                criteriaBuilder.equal(
                    transactionDtoRoot.get<String>("companyId"),
                    transactionSearchCriteria.companyId
                )
            )
        }
        if (Objects.nonNull(transactionSearchCriteria.cardNumber)) {
            predicates.add(
                criteriaBuilder.equal(
                    transactionDtoRoot.get<String>("cardNumber"),
                    transactionSearchCriteria.cardNumber
                )
            )
        }
        if (transactionSearchCriteria.dateTimeFrom != null) {
            predicates.add(
                criteriaBuilder.greaterThanOrEqualTo(
                    transactionDtoRoot.get<LocalDateTime>("trTime"),
                    transactionSearchCriteria.dateTimeFrom
                )
            )
        }
    }
}
