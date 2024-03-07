package br.com.souza.credit.application.system.service

import br.com.souza.credit.application.system.model.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustomer(customerId: Long): List<Credit>
    fun findByCreditCode(creditCode: UUID): Credit
}