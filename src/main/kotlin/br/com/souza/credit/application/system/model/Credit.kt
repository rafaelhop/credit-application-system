package br.com.souza.credit.application.system.model

import br.com.souza.credit.application.system.enumeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
data class Credit(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallment: Locale,
    @Column(nullable = false) val numberOfInstallment: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne var customer: Customer? = null
)