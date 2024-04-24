package br.com.souza.credit.application.system.dto

import br.com.souza.credit.application.system.model.Credit
import java.math.BigDecimal
import java.util.*

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallment: Int,
 ) {
    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstallment
    )

}
