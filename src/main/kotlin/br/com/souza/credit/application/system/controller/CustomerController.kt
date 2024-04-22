package br.com.souza.credit.application.system.controller

import br.com.souza.credit.application.system.dto.CustomerDto
import br.com.souza.credit.application.system.service.impl.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}