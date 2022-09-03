package ru.personalarea.repository

import org.springframework.data.repository.CrudRepository
import ru.personalarea.model.entity.ContractDto

interface ContractRepository : CrudRepository<ContractDto, Long> {
}