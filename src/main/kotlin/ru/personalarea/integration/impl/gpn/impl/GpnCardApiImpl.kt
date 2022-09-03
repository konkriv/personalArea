package ru.personalarea.integration.impl.gpn.impl

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.personalarea.integration.impl.HttpClientImpl
import ru.personalarea.integration.impl.gpn.GpnCardApi
import ru.personalarea.integration.impl.gpn.dto.card.BlockCardResponse

@Service
class GpnCardApiImpl(
    private val httpClient: HttpClientImpl
) : GpnCardApi {
    override fun blockCard(contractId: String, cardIds: List<String>, block: Boolean): ResponseEntity<BlockCardResponse> {
        try {
            return httpClient.postRequest(
                serviceName = "/blockCard",
                params = mapOf(
                    "contract_id" to contractId,
                    "card_id" to cardIds.toString(),
                    "block" to block.toString()
                ),
                responseClass = BlockCardResponse::class.java
            )
        } catch (e: Exception) {
            println(444444)
            throw e
        }
    }
}