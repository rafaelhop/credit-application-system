package br.com.souza.credit.application.system.dto

import br.com.souza.credit.application.system.model.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
     val firstName: String,
     val lastName: String,
     val income: BigDecimal,
     val zipCode: String,
     val street: String
 ) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName  = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
    return  customer
    }
}