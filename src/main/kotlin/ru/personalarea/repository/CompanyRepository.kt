package ru.personalarea.repository

import org.springframework.data.repository.CrudRepository
import ru.personalarea.model.entity.CompanyDto

interface CompanyRepository : CrudRepository<CompanyDto, Long> {
    fun findCompanyById(id: Long) : CompanyDto?
}