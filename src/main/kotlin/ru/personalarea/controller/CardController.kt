//package ru.personalarea.controller
//
//import org.springframework.http.HttpStatus
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.*
//import ru.personalarea.model.Card
//import ru.personalarea.model.Response
//import ru.personalarea.model.entity.CardDto
//import ru.personalarea.repository.CardRepository
//
//
//@RestController
//class CardController(
//    private val repo: CardRepository,
//    private val cardImpl: Card
//) {
//    @GetMapping("/cards", produces = ["application/json;charset=utf-8"])
//    fun getCompanies(): MutableIterable<CardDto> =  repo.findAll()
//
//    @PostMapping("/cards/blockCard", produces = ["application/json;charset=utf-8"])
//    fun blockCard(@RequestBody cardIds: List<Long>): ResponseEntity<Response<*>> {
//        val response = cardImpl.block(cardIds)
//        return ResponseEntity
//            .status(HttpStatus.OK)
//            .body(response)
//    }
//
//    @PostMapping("/cards/unblockCard", produces = ["application/json;charset=utf-8"])
//    fun unblockCard(@RequestBody cardIds: List<Long>): ResponseEntity<Response<*>> {
//        val response = cardImpl.unblock(cardIds)
//        return ResponseEntity
//            .status(HttpStatus.OK)
//            .body(response)
//    }
//}
