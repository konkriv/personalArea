package ru.personalarea.model.entity

import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import ru.personalarea.integration.impl.gpn.dto.limit.LimitData
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "card_groups")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
data class CardGroupDto(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long,
    val sourceId: String,
    val cardsCount: Int,
    val status: String,
    @OneToOne
    @JoinColumn(name = "company_id")
    val company: CompanyDto,
    val contractSourceId: String,
    @Type(type = "jsonb")
    var limits: List<LimitData>?,
) {}