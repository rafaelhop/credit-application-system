package br.com.souza.credit.application.system.controller

import br.com.souza.credit.application.system.dto.CreditDto
import br.com.souza.credit.application.system.dto.CreditView
import br.com.souza.credit.application.system.dto.CreditViewList
import br.com.souza.credit.application.system.service.impl.CreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val service: CreditService
) {

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>> {
        val creditViewList =  this.service.findAllByCustomer(customerId).stream()
            .map { credit -> CreditViewList(credit) }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long,
                         @PathVariable creditCode: UUID): ResponseEntity<CreditView> {
        val credit = this.service.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))

    }

    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String> {
        val credit = this.service.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body( "Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!")
    }
}