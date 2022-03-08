package com.example.marchseventh.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

//import com.kotlination.jpapostgresql.model.Customer   // bug package: again!! don't simply copy paste man!
import com.example.marchseventh.model.Customer

@Repository
interface CustomerRepository : CrudRepository<Customer, Long> {

    fun findByLastName(lastName: String): Iterable<Customer>
}