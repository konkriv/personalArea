package ru.personalarea.integration.impl.gpn.dto.limit

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
data class LimitData(
    val id: String,
    @JsonProperty("card_id")
    val cardId: String? = null,
    @JsonProperty("group_id")
    val groupId: String? = null,
    @JsonProperty("contract_id")
    val contractId: String,
    val sum: LimitSum? = null,
    val amount: LimitAmount? = null,
    val term: LimitTerm? = null,
    @JsonProperty("time")
    val time: LimitTime,
    val transactions: LimitTransaction? = null,
    val date: String,
    val productType: String,
    val productTypeName: String? = null,
    val productGroupName: String? = null,
    val productGroup:String? = null
) {
}