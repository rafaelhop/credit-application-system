package br.com.souza.credit.application.system.repository

import br.com.souza.credit.application.system.model.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode : UUID) : Credit?

    @Query(value = "select * from Credit where credit_id = ?1", nativeQuery = true)
    fun findAllByCustomer(customerId: Long) : List<Credit>
}