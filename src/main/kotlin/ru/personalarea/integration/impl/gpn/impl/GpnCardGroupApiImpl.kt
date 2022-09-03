package ru.personalarea.integration.impl.gpn.impl

import com.fasterxml.jackson.databind.JsonNode
import net.minidev.json.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import ru.personalarea.integration.HttpClient
import ru.personalarea.integration.impl.gpn.GpnCardGroupApi
import ru.personalarea.integration.impl.gpn.dto.`card-group`.CardList
import ru.personalarea.integration.impl.gpn.dto.response.GpnResponse

@Service
class GpnCardGroupApiImpl(
    private val httpClient: HttpClient
) : GpnCardGroupApi {
    override fun addCards(contractId: String, cardGroupId: String, cardList: String): ResponseEntity<GpnResponse> {
        return try {
            httpClient.postRequest(
                serviceName = "/setCardsToGroup",
                params = mapOf(
                    "contract_id" to contractId,
                    "group_id" to cardGroupId,
                    "cards_list" to cardList
                ),
                responseClass = GpnResponse::class.java
            )
        } catch (e: Exception) {
            println(33333)
            throw e
        }
    }

    override fun getCardGroups(contractId: String): ResponseEntity<GpnResponse> {
        return try {
            val params = LinkedMultiValueMap<String, String>().apply {
                add("contract_id", contractId)
            }
            httpClient.getRequest<GpnResponse>(
                serviceName = "/cardGroups",
                params = params,
                responseClass = GpnResponse::class.java
            )
        } catch (e: Exception) {
            println(33333)
            throw e
        }
    }

}