package ru.personalarea.model

import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "transactions")
class Transaction(
    @Id
    @GeneratedValue
    val id: Long,
    val contractId: Int,
    val companyId: Int,
    val createdAt: LocalDateTime,
    val cardNumber: Long,
    val cardComment: String?,
    val driver: String?,
    val ts: String?,
    val trTime: LocalDateTime,
    val tsType: String?,
    val azs: String?,
    val ownerTo: String,
    val product: String,
    val count: Double,
    val mesureUnit: String,
    val stellaCost: Double,
    val clientCost: Double,
    val sumWotDisc: Double,
    val sumDisc: Double,
    val sumPay: Double,
    val onOrOff: String?,
    val region: String?,
    val town: String?,
    val address: String?,
    val coords: String?,
    val probeg: String?,
    val trId: Long?,
    val terminalId: Long?,
    val companyCost: Double,
    val supplierCost: Double,
    val pureSum: Double,
    val supplierSum: Double,
    val companySum: Double,
    val oilSupplierId: Int,
    val azsOwner: String,
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