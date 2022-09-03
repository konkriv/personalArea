package ru.personalarea.model

import ru.personalarea.model.entity.ContractDto

interface Contract {
    fun updateBalance(contractId: Long): ContractDto
}