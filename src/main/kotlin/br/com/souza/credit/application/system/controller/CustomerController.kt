package br.com.souza.credit.application.system.controller

import br.com.souza.credit.application.system.dto.CustomerDto
import br.com.souza.credit.application.system.dto.CustomerUpdateDto
import br.com.souza.credit.application.system.dto.CustomerView
import br.com.souza.credit.application.system.service.impl.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val service: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCustomer = this.service.save(customerDto.toEntity())
        return "Customer ${savedCustomer.email} saved!"

    }

    @GetMapping("/{id}")
    fun findById( @PathVariable id: Long) : CustomerView {
        val customer = this.service.findById(id)
        return CustomerView(customer)
    }

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody customerUpdateDto: CustomerUpdateDto): CustomerView {
        val customer = this.service.findById(id)
        val customerToUpdate = customerUpdateDto.toEntity(customer)
        val customerUpdated = this.service.save(customerToUpdate)
        return CustomerView(customerUpdated)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer( @PathVariable id: Long)  = this.service.delete(id)
}