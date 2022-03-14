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

@Repository

class SaveDao {
    @Autowired
    lateinit var repository: CustomerRepository
    @PersistenceContext
    lateinit var entityManager: EntityManager

    fun save(saveBody: SaveBody): Boolean {
        // can not exist one with same name and same last name
        var customer = saveBody.getSaveCustomer()
        var firstName = customer.firstName
        var lastName = customer.lastName

        var people: Iterable<Customer> = repository.findByLastName(lastName)
        people.forEach {
            if (it.firstName == firstName) {
                return false
            }
        }

        // it can not do it, since the id is auto generating, so
        // when you enter, it will auto generate an id!!
//        var id = saveBody.getSaveCustomer().id
//        if (repository.existsById(id)) {
//            return false
//        }

        repository.save(saveBody.getSaveCustomer())
        return true;
    }


    fun findAll(): List<Customer> {
        return repository.findAll()
    }

    fun findById(id: Long): Optional<Customer> {
        return repository.findById(id)
    }

    fun findByLastName(lastName: String): Iterable<Customer> {
        return repository.findByLastName(lastName)
    }

//    @Modifying
//    @Transactional
//    @Query(
//        value = "truncate table customer",
//        nativeQuery = true
//    )
//    fun truncateAll() = true

    @Transactional
    fun deleteTableCustomer(tableName: String): Boolean  {
//        if (repository != null) {
//            entityManager.remove(repository)
//            return true
//        }

//        var flag = 1
//        try {
//            entityManager.remove(repository)
//        } catch (e: Exception) {
//            flag = 0
//            println("Some Error happend when removing table Customer")
//        } finally {
//            return flag == 1
//        }

        var flag = 1
        try {
            var query: String = "DROP TABLE IF EXISTS :tableName"
            entityManager.createNativeQuery(query).setParameter("tableName", tableName).executeUpdate()
        } catch (e: Exception) {
            println(e)
            flag = 0
        } finally {
            return flag == 1
        }
    }


    // truncateAll delete all contents,
    // but remain to use the same sequence for id generation
    fun truncateAll(): Boolean {
        var flag = 1  // 1 means true, 0 means false
        try {
            repository.deleteAll()
        } catch (e: Exception) {
            println("$e")
            flag = 0
        } finally {
            return flag == 1
        }
    }

    @Modifying
    @Transactional
    fun truncateById(id: Long): Boolean {
        var flag: Int = 1 // 1 means true, 0 means false
        try {
            repository.deleteById(id)
        } catch (e: Exception) {
            println("$e")
            flag = 0
        } finally {
            return flag == 1
        }
    }
}