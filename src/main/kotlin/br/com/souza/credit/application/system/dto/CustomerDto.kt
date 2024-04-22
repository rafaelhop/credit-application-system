package br.com.souza.credit.application.system.dto

import br.com.souza.credit.application.system.model.Address
import br.com.souza.credit.application.system.model.Customer
import java.math.BigDecimal

data class CustomerDto(
    val firstName : String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String

) {
    fun toEntity() : Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )


    )
}


