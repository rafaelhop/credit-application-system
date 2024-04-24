package br.com.souza.credit.application.system.controller

import br.com.souza.credit.application.system.dto.CreditDto
import br.com.souza.credit.application.system.dto.CreditViewList
import br.com.souza.credit.application.system.service.impl.CreditService
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val service: CreditService
) {

    @GetMapping
    fun findAllByCustomerId(@RequestParam customerId: Long) : List<CreditViewList> {
        return this.service.findAllByCustomer(customerId).stream()
            .map { credit -> CreditViewList(credit) }.collect(Collectors.toList())
    }

    @PostMapping
    fun saveCredit(@RequestBody creditDto: CreditDto) : String {
        val credit = this.service.save(creditDto.toEntity())
        return "Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!"
    }
}