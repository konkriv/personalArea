package ru.personalarea.integration.impl.gpn.dto.response

import com.fasterxml.jackson.databind.JsonNode

class GpnResponse(
    val status: GpnResponseStatus,
    val data: JsonNode,
    val timestamp: Int
) {
}