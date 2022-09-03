package ru.personalarea.model.impl

import org.springframework.stereotype.Service
import ru.personalarea.integration.impl.gpn.GpnCardApi
import ru.personalarea.model.Card
import ru.personalarea.model.Response
import ru.personalarea.model.entity.CardDto
import ru.personalarea.model.entity.CardStatusDto
import ru.personalarea.repository.CardRepository
import ru.personalarea.repository.CardStatusRepository

@Service
class CardImpl(
    private val cardStatusRepository: CardStatusRepository,
    private val cardRepo: CardRepository,
    private val gpnCardApi: GpnCardApi
) : Card {
    override fun block(cardIds: List<Long>): Response<List<String>> =
        blockCard(cardIds, true)

    override fun unblock(cardIds: List<Long>): Response<List<String>> =
        blockCard(cardIds, false)

    private fun blockCard(cardIds: List<Long>, block: Boolean): Response<List<String>> {
        val repoCards = cardRepo.findByIdIn(cardIds)
        val gpnResponse = gpnCardApi.blockCard(
            contractId = repoCards.first().contractSourceId,
            cardIds = repoCards.map { it.sourceId },
            block = block
        )
        val cards = updateCards(gpnResponse.body!!.cardsIds, getCardStatus(block))
        return Response(
            status = "SUCCESS",
            data = cards.map { it.cardNumber.toString() }
        )
    }


    private fun updateCards(cardsSourceIds: List<String>, cardStatus: CardStatusDto): List<CardDto> {
        return cardRepo.findBySourceIdIn(cardsSourceIds)
            .asSequence()
            .map {
                it.status = cardStatus
                cardRepo.save(it)
            }.toList()
    }

    private fun getCardStatus(block: Boolean): CardStatusDto {
        return if (block) {
            cardStatusRepository.findBySourceId("Locked(Manager)")
        } else {
            cardStatusRepository.findBySourceId("Active")
        }
    }
}