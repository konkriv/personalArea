package ru.personalarea.model

import javax.persistence.*

@Table(name = "sessions")
@Entity
data class Session(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int,
    val url: String,
    val token: String,
    val sessionId: String,
    private val port: Int,
    private val ssl: Int,
    private val login: String,
    private val password: String,
    private val oilSupplierId: Int,
    private val description: String,
    private val enabled: Boolean
) {

}