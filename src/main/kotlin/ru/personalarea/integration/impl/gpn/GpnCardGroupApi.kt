package ru.personalarea.integration.impl.gpn

import com.fasterxml.jackson.databind.JsonNode
import net.minidev.json.JSONObject
import org.springframework.http.ResponseEntity
import ru.personalarea.integration.impl.gpn.dto.`card-group`.CardList
import ru.personalarea.integration.impl.gpn.dto.response.GpnResponse

interface GpnCardGroupApi {
    fun addCards(contractId: String, cardGroupId: String, cardList: String): ResponseEntity<GpnResponse>
    fun getCardGroups(contractId: String): ResponseEntity<GpnResponse>
}