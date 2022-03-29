package com.example.marchseventh.dao

import org.springframework.stereotype.Repository

import com.example.marchseventh.entity.db.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {
    // https://www.baeldung.com/spring-data-derived-queries
    // why it worked? because it is called Derived Query Methods in Spring Data JPA Repos
    fun findByLastName(lastName: String): Iterable<Customer>
}