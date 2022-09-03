package ru.personalarea.model.entity

import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "card_statuses")
class CardStatusDto(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long,
    val sourceId: String,
    val value: String
) {}