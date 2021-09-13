package ru.personalarea.repository

import org.springframework.data.repository.CrudRepository
import ru.personalarea.model.Company

interface CompanyRepository : CrudRepository<Company, Long> {
    fun findCompanyById(id: Long) : Company?
}