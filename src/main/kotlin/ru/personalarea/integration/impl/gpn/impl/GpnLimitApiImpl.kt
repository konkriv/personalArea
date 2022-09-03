package ru.personalarea.integration.impl.gpn.impl

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import ru.personalarea.integration.impl.HttpClientImpl
import ru.personalarea.integration.impl.gpn.GpnLimitApi
import ru.personalarea.integration.impl.gpn.dto.`card-group`.CardList
import ru.personalarea.integration.impl.gpn.dto.response.GpnResponse

@Service
class GpnLimitApiImpl(
    private val httpClient: HttpClientImpl
) : GpnLimitApi {
    override fun getLimitsByCard(contractId: String, cardId: String): ResponseEntity<String> {
        val params = LinkedMultiValueMap<String, String>().apply {
            add("contract_id", contractId)
            add("card_id", cardId)
        }

        return try {
            httpClient.getRequest<String>(
                serviceName = "/limit",
                params = params,
                responseClass = String::class.java
            )
        } catch (e: Exception) {
            println(33333)
            throw e
        }
    }


    override fun getLimitsByCardGroup(contractId: String, cardGroupId: String): ResponseEntity<GpnResponse> {
        val params = LinkedMultiValueMap<String, String>().apply {
            add("contract_id", contractId)
            add("group_id", cardGroupId)
        }

        return try {
            httpClient.getRequest<GpnResponse>(serviceName = "/limit?", params = params, responseClass = GpnResponse::class.java)
        } catch (e: Exception) {
            println(33333)
            throw e
        }
    }

    override fun setLimit(limits: String): ResponseEntity<GpnResponse> {
        return try {
            httpClient.postRequest<GpnResponse>(
                serviceName = "/setLimit",
                params = mapOf("limit" to limits),
                responseClass = GpnResponse::class.java)
        } catch (e: Exception) {
            println(33333)
            throw e
        }
    }
}