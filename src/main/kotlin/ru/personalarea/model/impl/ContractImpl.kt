package ru.personalarea.model.impl

import org.springframework.stereotype.Service
import ru.personalarea.integration.impl.gpn.impl.GpnContractApiImpl
import ru.personalarea.model.Contract
import ru.personalarea.model.entity.ContractDto
import ru.personalarea.repository.ContractRepository

@Service
class ContractImpl(
    private val repo: ContractRepository,
    private val gpnContractApiImpl: GpnContractApiImpl
) : Contract {
    override fun updateBalance(contractId: Long): ContractDto {
        val contract = repo.findById(contractId).get()
        val gpnResponse = gpnContractApiImpl.getPartContractData(contract.sourceId)
        contract.balance = gpnResponse.body!!.getBalance()
        repo.save(contract)
        return contract
    }
}