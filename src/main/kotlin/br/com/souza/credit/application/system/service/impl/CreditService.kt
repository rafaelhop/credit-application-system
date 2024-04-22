package br.com.souza.credit.application.system.service.impl

import br.com.souza.credit.application.system.model.Credit
import br.com.souza.credit.application.system.repository.CreditRepository
import br.com.souza.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val repository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.repository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.repository.findAllByCustomer(customerId)


    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.repository.findByCreditCode(creditCode)
            ?: throw RuntimeException("CreditCode $creditCode not found"))

        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }
}