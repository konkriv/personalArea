package ru.personalarea.model.entity

import javax.persistence.*

@Table(name = "sessions")
@Entity
data class SessionDto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int,
    val url: String,
    val token: String,
    var sessionId: String,
    private val port: Int,
    private val ssl: Int,
    private val login: String,
    private val password: String,
    private val oilSupplierId: Int,
    private val description: String,
    private val enabled: Boolean
) {

}