package ru.personalarea.model

import org.springframework.http.ResponseEntity
import ru.personalarea.integration.impl.gpn.dto.`card-group`.CardList
import ru.personalarea.integration.impl.gpn.dto.`card-group`.GpnCardGroupListResponseDto
import ru.personalarea.integration.impl.gpn.dto.response.GpnResponse
import ru.personalarea.model.entity.CardGroupDto

interface CardGroup {
    fun updateFromServer(contractId: String): GpnCardGroupListResponseDto
    fun updateLimits(contractId: String, cardGroupId: Long): CardGroupDto
    fun addCards(contractId: String, cardGroupId: String, cardIds: List<Long>): ResponseEntity<GpnResponse>
    fun removeCards(contractId: String, cardGroupId: String, cardIds: List<Long>): ResponseEntity<GpnResponse>
    fun setRubLimit(cardGroupId: Long, sum: Int)
}