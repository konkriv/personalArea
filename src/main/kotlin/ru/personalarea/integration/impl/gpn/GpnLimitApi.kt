package ru.personalarea.integration.impl.gpn

import org.springframework.http.ResponseEntity
import ru.personalarea.integration.impl.gpn.dto.`card-group`.CardList
import ru.personalarea.integration.impl.gpn.dto.response.GpnResponse

interface GpnLimitApi {
    fun getLimitsByCard(contractId: String, cardId: String): ResponseEntity<String>
    fun getLimitsByCardGroup(contractId: String, cardGroupId: String): ResponseEntity<GpnResponse>
    fun setLimit(limits: String): ResponseEntity<GpnResponse>
    }