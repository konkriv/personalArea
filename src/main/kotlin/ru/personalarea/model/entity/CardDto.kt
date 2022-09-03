package ru.personalarea.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.*
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "cards")
class CardDto(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long,
    val sourceId: String,
    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonBackReference
    val company: CompanyDto,

    @OneToOne
    @JoinColumn(name = "card_status_id", referencedColumnName = "id")
    @JsonManagedReference
    var status: CardStatusDto,
    val cardNumber: Long,
    val contractSourceId: String,

    @JsonIgnore
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    var createdAt: Date? = null,

    @JsonIgnore
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt: Date? = null
) {
    @PrePersist
    protected fun onCreate() {
        createdAt = Date()
        updatedAt = Date()
    }

    @PreUpdate
    protected fun onUpdate() {
        updatedAt = Date()
    }
}