//package ru.personalarea.controller
//
//import org.springframework.http.HttpStatus
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.*
//import ru.personalarea.integration.impl.gpn.impl.GpnContractApiImpl
//import ru.personalarea.integration.impl.gpn.impl.GpnTransactionApiImpl
//import ru.personalarea.model.entity.ContractDto
//import ru.personalarea.model.impl.ContractImpl
//
//@RestController
//class ContractControllerRestApi(
//    private val gpnTransactionApiImpl: GpnTransactionApiImpl,
//    private val contractImpl: ContractImpl,
//    private val gpnContractApiImpl: GpnContractApiImpl
//) {
//
//    @GetMapping("/contractDataFromGpn", produces = ["application/json;charset=utf-8"])
//    fun contractDataFromGpn(contractId: String) = gpnContractApiImpl.getPartContractData(contractId)
//
//    @PostMapping("/updateContractBalance", produces = ["application/json;charset=utf-8"])
//    fun updateContractBalance(contractId: Long): ResponseEntity<ContractDto>{
//        val contract =  contractImpl.updateBalance(contractId)
//        return ResponseEntity
//            .status(HttpStatus.OK)
//            .body(contract)
//    }
//
//    @GetMapping("/getLast30TransactionsFromGpn", produces = ["application/json;charset=utf-8"])
//    fun getLast30TransactionsFromGpn() = gpnTransactionApiImpl.getLast30Transactions("1-6Y7NH1W")
//}