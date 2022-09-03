package ru.personalarea.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.personalarea.model.entity.TransactionDto;
import ru.personalarea.model.entity.TransactionPage;
import ru.personalarea.model.entity.TransactionSearchCriteria;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class TransactionCriteriaRepositoryJava {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public TransactionCriteriaRepositoryJava(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<TransactionDto> findAllWithFilters(
            TransactionPage transactionPage,
            TransactionSearchCriteria transactionSearchCriteria){
        CriteriaQuery<TransactionDto> criteriaQuery = criteriaBuilder.createQuery(TransactionDto.class);
        Root<TransactionDto> transactionRoot = criteriaQuery.from(TransactionDto.class);
        Predicate predicate = getPredicate(transactionSearchCriteria, transactionRoot);
        criteriaQuery.where(predicate);
        setOrder(transactionPage, criteriaQuery, transactionRoot);

        TypedQuery<TransactionDto> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(transactionPage.getPageNumber() * transactionPage.getPageSize());
        typedQuery.setMaxResults(transactionPage.getPageSize());

        Pageable pageable = getPageable(transactionPage);

        Long transactionsCount = getTransactionsCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, transactionsCount);
    }


    private Predicate getPredicate(
            TransactionSearchCriteria transactionSearchCriteria,
            Root<TransactionDto> transactionDtoRoot
    ){
        List<Predicate> predicates = new ArrayList<>();

        if(Objects.nonNull(transactionSearchCriteria.getCompanyId())){
            predicates.add(criteriaBuilder.equal(transactionDtoRoot.get("company_id"), transactionSearchCriteria.getCompanyId()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(TransactionPage transactionPage,
                          CriteriaQuery<TransactionDto> criteriaQuery,
                          Root<TransactionDto> transactionRoot) {
        if (transactionPage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.asc(transactionRoot.get(transactionPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(transactionRoot.get(transactionPage.getSortBy())));
        }
    }

    private Pageable getPageable(TransactionPage transactionPage) {
        Sort sort = Sort.by(transactionPage.getSortDirection(), transactionPage.getSortBy());
        return PageRequest.of(transactionPage.getPageNumber(), transactionPage.getPageSize(), sort);
    }

    private Long getTransactionsCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<TransactionDto> countRoot = countQuery.from(TransactionDto.class);
        countQuery.select(criteriaBuilder.count(countRoot )).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }
}
