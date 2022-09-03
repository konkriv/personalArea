//package ru.personalarea.controller
//
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.RestController
//import ru.personalarea.integration.impl.gpn.GpnLimitApi
//import ru.personalarea.model.CardGroup
//
//@RestController
//class LimitController(
////    private val limitApi: GpnLimitApi
//    private val cardGroupService: CardGroup
//) {
////    @GetMapping("/contractDataFromGpn", produces = ["application/json;charset=utf-8"])
////    fun contractDataFromGpn(contractId: String) = limitApi.getPartContractData(contractId)
//
//    @GetMapping("/card-group/{cardGroupId}/limits", produces = ["application/json;charset=utf-8"])
//    fun getCardGroupLimits(
//        contractId: String,
//        @PathVariable
//        cardGroupId: Long
//    ) = cardGroupService.updateLimits(contractId, cardGroupId)
//
////    @GetMapping("/card-group/limits", produces = ["application/json;charset=utf-8"])
////    fun getCardGroupLimits2(
////        contractId: String,
////        cardGroupId: Int
////    ) = limitApi.getLimitsByCardGroup(contractId, cardGroupId.toString())
//
////    @GetMapping("/cards/{cardId}/limits", )
////    fun getLimitsByCard((required = false) companyId: Long, model: Model): String {
////        val company = repo.findCompanyById(companyId)
////        model.addAttribute("company", company)
////        return "company"
////    }
//}