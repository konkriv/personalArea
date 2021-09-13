package ru.personalarea.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "companies")
class Company(
    @Id
    @GeneratedValue
    val id: Long,
    val shortName: String,
    val fullName: String,
    @JsonManagedReference
    @OneToMany(mappedBy = "company")
    val cards: List<Card>
) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}