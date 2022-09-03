package ru.personalarea.integration.impl.gpn

import org.springframework.http.ResponseEntity

interface GpnTransactionApi {
    fun getLast30Transactions(contractId: String): ResponseEntity<String>
}