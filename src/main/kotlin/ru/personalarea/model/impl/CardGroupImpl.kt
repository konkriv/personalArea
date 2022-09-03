package ru.personalarea.model.impl

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.util.JSONPObject
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.treeToValue
import net.minidev.json.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.personalarea.integration.impl.gpn.GpnCardGroupApi
import ru.personalarea.integration.impl.gpn.GpnLimitApi
import ru.personalarea.integration.impl.gpn.dto.`card-group`.CardList
import ru.personalarea.integration.impl.gpn.dto.`card-group`.GpnCardGroupListResponseDto
import ru.personalarea.integration.impl.gpn.dto.limit.LimitData
import ru.personalarea.integration.impl.gpn.dto.limit.LimitResponseData
import ru.personalarea.integration.impl.gpn.dto.limit.LimitSum
import ru.personalarea.integration.impl.gpn.dto.response.GpnResponse
import ru.personalarea.model.CardGroup
import ru.personalarea.model.entity.CardGroupDto
import ru.personalarea.repository.CardGroupRepository
import ru.personalarea.repository.CardRepository

@Service
class CardGroupImpl(
    val repo: CardGroupRepository,
    val gpnCardGroupApi: GpnCardGroupApi,
    val gpnLimitApi: GpnLimitApi,
    val cardRepo: CardRepository
) : CardGroup {
    override fun updateFromServer(contractId: String): GpnCardGroupListResponseDto {
        val gpnResponse = gpnCardGroupApi.getCardGroups(contractId)
        val gpnCardGroupListResponseDto = gpnResponse.body?.data?.let { jacksonObjectMapper().treeToValue<GpnCardGroupListResponseDto>(it) }
        return gpnCardGroupListResponseDto!!
    }

    override fun updateLimits(contractId: String, cardGroupId: Long): CardGroupDto {
        val cardGroup = repo.findById(cardGroupId).get()
        val gpnResponse = gpnLimitApi.getLimitsByCardGroup(contractId, cardGroup.sourceId)
        val limitsData = gpnResponse.body?.data?.let { jacksonObjectMapper().treeToValue<LimitResponseData>(it) }
        val limits = limitsData?.limits
        cardGroup.limits = limits
        repo.save(cardGroup)
        return cardGroup
    }

    override fun setRubLimit(cardGroupId: Long, sum: Int) {
        val cardGroup = repo.findById(cardGroupId).get()
        val limit = cardGroup.limits?.first()!!
        limit.sum?.value = sum
        val newLimit = listOf(
            LimitData(
                id = limit.id,
                groupId = limit.groupId,
                contractId = limit.contractId,
                time = limit.time,
                date = limit.date,
                productType = limit.productType,
                sum = LimitSum(
                    currency = limit.sum?.currency!!,
                    value = limit.sum.value
                ),
                term = limit.term
            )
        )
        val limitJson = jacksonObjectMapper().valueToTree<JsonNode>(newLimit)
        gpnLimitApi.setLimit(limitJson.toString())
    }

    override fun addCards(
        contractId: String,
        cardGroupId: String,
        cardIds: List<Long>
    ): ResponseEntity<GpnResponse> {
        val cards = cardRepo.findByIdIn(cardIds)
        val cardList = cards.map { CardList(it.sourceId, "Attach") }
        val cardListJson = jacksonObjectMapper().valueToTree<JsonNode>(cardList)
        val cardListJsonObject = JSONObject(
            mapOf(
                "contract_id" to contractId,
                "group_id" to cardGroupId,
                "cards_list" to cardListJson
            )
        )
        return gpnCardGroupApi.addCards(contractId, cardGroupId, cardListJson.toString())
    }

    override fun removeCards(
        contractId: String,
        cardGroupId: String,
        cardIds: List<Long>
    ): ResponseEntity<GpnResponse> {
        val cards = cardRepo.findByIdIn(cardIds)
        val cardList = cards.map { CardList(it.sourceId, "Detach") }
        val cardListJson = jacksonObjectMapper().valueToTree<JsonNode>(cardList)
        val cardListJsonObject = JSONObject(
            mapOf(
                "contract_id" to contractId,
                "group_id" to cardGroupId,
                "cards_list" to cardListJson
            )
        )
        return gpnCardGroupApi.addCards(contractId, cardGroupId, cardListJson.toString())
    }
}