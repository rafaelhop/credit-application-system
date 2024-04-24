package br.com.souza.credit.application.system.dto

import br.com.souza.credit.application.system.model.Credit
import br.com.souza.credit.application.system.model.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallment: Int,
    val customerId: Long,

) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallment = this.numberOfInstallment,
        customer = Customer(id = this.customerId)
    )

}
