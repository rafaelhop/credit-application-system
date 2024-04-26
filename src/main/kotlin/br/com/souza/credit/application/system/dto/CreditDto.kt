package br.com.souza.credit.application.system.dto

import br.com.souza.credit.application.system.model.Credit
import br.com.souza.credit.application.system.model.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
   @field:NotNull val creditValue: BigDecimal,
   @field:Future val dayFirstOfInstallment: LocalDate,
   @field:NotEmpty val numberOfInstallment: Int,
   @field:NotNull val customerId: Long,

) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallment = this.numberOfInstallment,
        customer = Customer(id = this.customerId)
    )
}
