package ru.personalarea.integration.impl.gpn

import org.springframework.http.ResponseEntity
import ru.personalarea.integration.impl.gpn.dto.card.BlockCardResponse

interface GpnCardApi {
    fun blockCard(contractId: String, cardIds: List<String>, block: Boolean): ResponseEntity<BlockCardResponse>
}