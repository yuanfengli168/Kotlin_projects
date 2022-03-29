package com.example.marchseventh.service

import com.example.marchseventh.dao.CustomerRepository
import com.example.marchseventh.entity.db.Customer
import com.example.marchseventh.entity.request.SaveBody
import com.example.marchseventh.dao.SaveDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.persistence.EntityManager
import javax.swing.text.html.parser.Entity

@Service
class SaveService {

    @Autowired
    lateinit var saveDao: SaveDao

    fun save(saveBody: SaveBody): Boolean {
        val customer = saveBody.getSaveCustomer()
        val firstName = customer.firstName
        val lastName = customer.lastName

        val people: Iterable<Customer> = findByLastName(lastName)
        people.forEach{
            if (it.firstName == firstName) {
                return false
            }
        }
        saveDao.save(customer)
        return true
    }


    fun findAll(): List<*> {
        return saveDao.findAll()
    }

    fun findById(id: Long): Optional<Customer> {
        return saveDao.findById(id)
    }

    fun findByLastName(lastName: String): Iterable<Customer> {
        return saveDao.findByLastName(lastName)
    }

    fun findByFirstName(firstName: String): Iterable<Customer> {
        return saveDao.findByFirstName(firstName)
    }

    fun truncateAll(): Boolean {
        return saveDao.truncateAll()
    }

    fun truncateById(id: Long): Boolean {
        return saveDao.truncateById(id)
    }


}