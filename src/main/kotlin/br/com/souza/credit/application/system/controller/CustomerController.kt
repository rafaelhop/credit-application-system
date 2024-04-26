package br.com.souza.credit.application.system.controller

import br.com.souza.credit.application.system.dto.CustomerDto
import br.com.souza.credit.application.system.dto.CustomerUpdateDto
import br.com.souza.credit.application.system.dto.CustomerView
import br.com.souza.credit.application.system.service.impl.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val service: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDto: CustomerDto): ResponseEntity<String> {
        val savedCustomer = this.service.save(customerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body( "Customer ${savedCustomer.email} saved!")

    }

    @GetMapping("/{id}")
    fun findById( @PathVariable id: Long): ResponseEntity<CustomerView> {
        val customer = this.service.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody @Valid customerUpdateDto: CustomerUpdateDto): ResponseEntity<CustomerView> {
        val customer = this.service.findById(id)
        val customerToUpdate = customerUpdateDto.toEntity(customer)
        val customerUpdated = this.service.save(customerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer( @PathVariable id: Long)  = this.service.delete(id)
}