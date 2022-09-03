package ru.personalarea.model.impl

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.personalarea.model.CardGroup
import ru.personalarea.repository.CardGroupRepository
import ru.personalarea.repository.CardRepository
import java.time.LocalDateTime

@SpringBootTest
internal class CardGroupImplTest(
    @Autowired private val service: CardGroup,
    @Autowired private val cardRepo: CardRepository,
    @Autowired private val cardGroupRepo: CardGroupRepository
) {
    @Test
    fun test() {
        val res = service.updateLimits("1-6Y7NH1W", 5624)
        println(res)
    }

    @Test
    fun test2() {
        println(LocalDateTime.now())
        val res = service.setRubLimit(5624, 150)
        println(res)
        println(LocalDateTime.now())
    }

//    @Test
//    fun removeCards() {
//        val cardNumbers = listOf(7005830017072836, 7005830017072844, 7005830017072851, 7005830017072869, 7005830017072877, 7005830017072885, 7005830017072893, 7005830017072901, 7005830017072919, 7005830017072927, 7005830017072935, 7005830017072943, 7005830017072950, 7005830017072968, 7005830017072976, 7005830017072984, 7005830017072992, 7005830017073008, 7005830017073016, 7005830017073024, 7005830017073032, 7005830017073040, 7005830017073057, 7005830017073065, 7005830017073073, 7005830017073081, 7005830017073099, 7005830017073107, 7005830017073115, 7005830017073123, 7005830017073131, 7005830017073149, 7005830017073156, 7005830017073164, 7005830017073172, 7005830017073180, 7005830017073198, 7005830017073206, 7005830017073214, 7005830017073222, 7005830017073230, 7005830017073248, 7005830017073255, 7005830017073263, 7005830017073271, 7005830017073289, 7005830017073297, 7005830017073305, 7005830017073313, 7005830017073321)
//        val cards = cardRepo.findByCardNumberIn(cardNumbers)
//        val cardIds = cards.map { it.id }
//        println(cards.size)
//
//        service.removeCards("1-6Y7NH1W", "1-HRUQJGC", cardIds)
//    }
//    @Test
//    fun addCards() {
//        val cardNumbers = listOf(7005830017072836, 7005830017072844, 7005830017072851, 7005830017072869, 7005830017072877, 7005830017072885, 7005830017072893, 7005830017072901, 7005830017072919, 7005830017072927, 7005830017072935, 7005830017072943, 7005830017072950, 7005830017072968, 7005830017072976, 7005830017072984, 7005830017072992, 7005830017073008, 7005830017073016, 7005830017073024, 7005830017073032, 7005830017073040, 7005830017073057, 7005830017073065, 7005830017073073, 7005830017073081, 7005830017073099, 7005830017073107, 7005830017073115, 7005830017073123, 7005830017073131, 7005830017073149, 7005830017073156, 7005830017073164, 7005830017073172, 7005830017073180, 7005830017073198, 7005830017073206, 7005830017073214, 7005830017073222, 7005830017073230, 7005830017073248, 7005830017073255, 7005830017073263, 7005830017073271, 7005830017073289, 7005830017073297, 7005830017073305, 7005830017073313, 7005830017073321)
//        val cards = cardRepo.findByCardNumberIn(cardNumbers)
//        val cardIds = cards.map { it.id }
////        val cardList = cards.map { CardList(it.sourceId, "Attach") }
//
//        service.addCards("1-6Y7NH1W", "1-11BNXPYV", cardIds)
//    }

    @Test
    fun test4() {
        val cardGroup = cardGroupRepo.findById(5624)
        println(cardGroup)
    }

    @Test
    fun getCardGroupsFromSource() {
        val result = (service.updateFromServer("1-6Y7NH1W"))
        result.cardGroupList.forEach {
            if (it.id == "1-HRUQJGC") {
                println(1111111)
                println(it.cardsCount)
                println(2222222)
            }
        }
    }

    @Test
    fun getCardGroupsFromTarget() {
        val result = (service.updateFromServer("1-6Y7NH1W"))
        result.cardGroupList.forEach {
            if (it.id == "1-11BNXPYV") {
                println(1111111)
                println(it)
                println(2222222)
            }
        }
    }


}