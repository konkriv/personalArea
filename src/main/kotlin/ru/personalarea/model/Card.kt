package ru.personalarea.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "cards")
data class Card(
    @Id
    @GeneratedValue
    private val id: Long,
    private val cardNumber: String,
    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonBackReference
    private val company: Company
) {
}