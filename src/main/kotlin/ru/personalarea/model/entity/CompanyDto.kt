package ru.personalarea.model.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "companies")
class CompanyDto(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long,
    val shortName: String,
    val fullName: String,
    @JsonManagedReference
    @OneToMany(mappedBy = "company")
    val cards: List<CardDto>
) {}