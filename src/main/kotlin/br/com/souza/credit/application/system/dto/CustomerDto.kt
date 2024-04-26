package br.com.souza.credit.application.system.dto

import br.com.souza.credit.application.system.model.Address
import br.com.souza.credit.application.system.model.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
   @field:NotEmpty val firstName : String,
   @field:NotEmpty val lastName: String,
   @field:NotEmpty @CPF val cpf: String,
    @field:NotNull val income: BigDecimal,
   @field:NotEmpty @Email val email: String,
   @field:NotEmpty val password: String,
   @field:NotEmpty val zipcode: String,
   @field:NotEmpty val street: String

) {
    fun toEntity() : Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipcode = this.zipcode,
            street = this.street
        )
    )
}