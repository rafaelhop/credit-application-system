package br.com.souza.credit.application.system.model

import br.com.souza.credit.application.system.enumeration.Status
import java.math.BigDecimal
import java.util.Locale
import java.util.UUID

data class Credit(
    val id: Long? = null,
    val creditCode: UUID = UUID.randomUUID(),
    val creditValue: BigDecimal = BigDecimal.ZERO,
    val dayFirstInstallment: Locale,
    val numberOfInstallment: Int = 0,
    val status: Status = Status.IN_PROGRESS,
    val customer: Customer? = null
)