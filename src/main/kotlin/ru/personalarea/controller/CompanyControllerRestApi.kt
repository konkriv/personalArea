package ru.personalarea.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.personalarea.controller.exception.IdNotFoundException
import ru.personalarea.model.Company
import ru.personalarea.repository.CompanyRepository
import javax.persistence.EntityManager


@RestController
class CompanyControllerRestApi(
    private val em: EntityManager,
    private val repo: CompanyRepository,
) {

    @GetMapping("/companies", produces = ["application/json;charset=utf-8"])
    fun getCompanies(): MutableIterable<Company> = repo.findAll()

    @GetMapping("/companies/{companyId}", produces = ["application/json;charset=utf-8"])
    fun getCompanyById(@PathVariable companyId: Long): Company {
       return repo.findCompanyById(companyId) ?: throw IdNotFoundException("Ошибка: Компания с id $companyId не найдена")
    }

    @GetMapping("/companiesWithCards", produces = ["application/json;charset=utf-8"])
    fun getCompaniesWithCards(): List<*> {
        val query = em.createQuery("select distinct company from Company company  left join fetch company.cards cards")
        return query.resultList
    }

    @GetMapping("/companiesWithCards/{companyId}", produces = ["application/json;charset=utf-8"])
    fun getCompanyWithCards(@PathVariable(required = false) companyId: Long): Any {
        val query = em.createQuery(
            "select distinct company from Company company left join fetch company.cards cards where company.id = :id"
        )
        query.setParameter("id", companyId)
        return query.singleResult
    }
}