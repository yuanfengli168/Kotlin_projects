package com.example.marchseventh.dao

import org.springframework.stereotype.Repository

//import com.kotlination.jpapostgresql.model.Customer   // bug package: again!! don't simply copy paste man!
import com.example.marchseventh.entity.db.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

@Repository
//interface CustomerRepository : CrudRepository<Customer, Long> {
interface CustomerRepository : JpaRepository<Customer, Long> {
//    @Query(value = "SELECT * FROM Customer", nativeQuery = true)
//    fun findByLastNameAndFirstName(lastName: String, firstName: String): Iterable<Customer>
    fun findByLastName(lastName: String): Iterable<Customer>

    @Modifying
    @Query(
        value = "truncate table Customer",
        nativeQuery = true
    )
    fun truncateMyTable()
}