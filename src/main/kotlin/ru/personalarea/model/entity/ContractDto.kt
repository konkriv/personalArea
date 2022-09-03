package ru.personalarea.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.*
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY


@Entity
@Table(name = "contracts")
class ContractDto(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,
    val sourceId: String,
    val name: String,
    var balance: Double,

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