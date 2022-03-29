package com.example.marchseventh.dao

import com.example.marchseventh.entity.db.Customer
import com.example.marchseventh.entity.request.SaveBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Modifying
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.SequenceGenerator

/**
 * SaveDao connects to Postgres,
 * My rule is to make it as clean as possible, all the logic is in service.kt files.
 * @author      Yuanfeng Li
 * @version     2.1, 03/28/2022
 *
 */
@Repository
class SaveDao {
    @Autowired
    lateinit var repository: CustomerRepository

    fun save(customer: Customer) {
        try {
            repository.save(customer)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun findAll(): List<Customer> {
        return repository.findAll()
    }


    fun findById(id: Long): Optional<Customer> {
        return try {
            repository.findById(id)
        } catch (e: Exception) {
            e.printStackTrace()
            Optional.empty()
        }
    }

    // Did not write try and catch
    fun findByLastName(lastName: String): Iterable<Customer> {
        return repository.findByLastName(lastName)
    }

    fun findByFirstName(firstName: String): Iterable<Customer> {
        return repository.findByFirstName(firstName)
    }

    // truncateAll delete all contents,
    // but remain to use the same sequence for id generation
    fun truncateAll(): Boolean {
        return try {
            repository.deleteAll()
            true
        } catch (e: Exception){
            e.printStackTrace()
            false
        }
    }

    fun truncateById(id: Long): Boolean {
        return try {
            repository.deleteById(id)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}