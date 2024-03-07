package br.com.souza.credit.application.system.service.impl

import br.com.souza.credit.application.system.model.Customer
import br.com.souza.credit.application.system.repository.CustomerRepository
import br.com.souza.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val repository: CustomerRepository
): ICustomerService {
    override fun save(customer: Customer): Customer = this.repository.save(customer)

    override fun findById(id: Long): Customer = this.repository.findById(id).orElseThrow() {
            throw RuntimeException("Id $id not found!")
        }

    override fun delete(id: Long) =  this.repository.deleteById(id);
}