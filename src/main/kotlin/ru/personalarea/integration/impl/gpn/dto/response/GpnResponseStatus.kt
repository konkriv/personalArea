package ru.personalarea.integration.impl.gpn.dto.response

class GpnResponseStatus(
    val code: Int,
    val errors: List<GpnResponseStatusError>?
) {
}