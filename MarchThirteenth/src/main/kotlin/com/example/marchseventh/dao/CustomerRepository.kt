package com.example.marchseventh.dao

import org.springframework.stereotype.Repository

import com.example.marchseventh.entity.db.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {
    fun findByLastName(lastName: String): Iterable<Customer>

    @Modifying
    @Query(
        value = "truncate table Customer",
        nativeQuery = true
    )
    fun truncateMyTable()
}