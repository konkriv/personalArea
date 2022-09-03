//package ru.personalarea.model
//
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import ru.personalarea.model.entity.Contract
//import ru.personalarea.repository.ContractRepository
//
//@SpringBootTest
//internal class ContractTest(
//    @Autowired private val repo: ContractRepository
//){
//    @Test
//    fun test(){
//        val contract = Contract(
//            sourceId = "sourceId",
//            name = "name",
//            balance = 192.3
//        )
//        repo.save(contract)
//    }
//}