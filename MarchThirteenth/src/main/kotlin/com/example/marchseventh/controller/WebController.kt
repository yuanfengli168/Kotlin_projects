package com.example.marchseventh.controller

import org.springframework.beans.factory.annotation.Autowired

import com.example.marchseventh.dao.CustomerRepository
//import com.kotlination.jpapostgresql.model.Customer  // bug2: with wrong package
import com.example.marchseventh.entity.db.Customer
import org.springframework.http.HttpRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse
import com.example.marchseventh.entity.request.SaveBody
import com.example.marchseventh.service.SaveService
import org.springframework.http.HttpStatus
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@RestController
class WebController {

//    @Autowired
//    lateinit var repository: CustomerRepository

//    @RequestMapping(path = ["/save"], method = [RequestMethod.POST] )
////    @PostMapping(path = ["/save"])
//    fun save(): ResponseEntity<*> {
//        repository.save(Customer(firstName = "Jack", lastName = "Smith"))
////        repository.save(Customer("Adam", "Johnson"))
////        repository.save(Customer("Kim", "Smith"))
////        repository.save(Customer("David", "Williams"))
////        repository.save(Customer("Peter", "Davis"))
//
////        return "Done"
//        return ResponseEntity.ok(mapOf("Message" to "Done"))
//    }
    @Autowired
    lateinit var saveService: SaveService
    @PersistenceContext
    lateinit var entityManager: EntityManager

    @RequestMapping(path = ["/save"], method = [RequestMethod.POST])
    fun save(@RequestBody saveBody: SaveBody, response: HttpServletResponse): ResponseEntity<*> {
        if (!saveService.save(saveBody)) {
//            var rE = ResponseEntity(HttpStatus.CONFLICT)
//            return rE
            return ResponseEntity.ok(mapOf("Message" to "There existed one in db, please adjust!"))
        }
        return ResponseEntity.ok(mapOf("Message" to "Your request hase inserted to the database!"))
    }

    @RequestMapping("/findall")
    fun findAll(): List<*> {
        return saveService.findAll()
//        return ResponseEntity.ok(mapOf("All" to "List ${saveService.findAll()}"))
    }
//
    @RequestMapping("/findbyid/{id}")
    fun findById(@PathVariable id: Long)
            = saveService.findById(id)
//
    @RequestMapping("findbylastname/{lastName}")
    fun findByLastName(@PathVariable lastName: String)
            = saveService.findByLastName(lastName)

    // remain same sequence, but truncate all content in table Customer
    @RequestMapping("deleteAllContentInCustomer")
    fun truncateAll(): ResponseEntity<*> {
        saveService.truncateAll()
        return ResponseEntity.ok(mapOf("Message" to "Has truncated the Customer table successfully!"))
    }

    @RequestMapping("deleteById/{id}")
    fun truncateById(@PathVariable id: Long): ResponseEntity<*> {
        if (!saveService.truncateById(id)) {
            return ResponseEntity.ok(mapOf("Error" to "can't delete $id in db"))
        }
        return ResponseEntity.ok(mapOf("OK" to "deleted $id in db!"))
    }

//    // not remain same sequence, delete customer table!
//    @RequestMapping("deleteTableCustomer")
//    fun deleteTableCustomer(entityManager: EntityManager, tableName: String): ResponseEntity<*> {
//        if (saveService.deleteTableCustomer(entityManager, tableName)) {
//            return ResponseEntity.ok(mapOf("OK" to "The customer table is removed from db!"))
//        }
//        return ResponseEntity.ok(mapOf("Error" to "Some error happened! the customer table not removed successfully!"))
//    }

    // not remain same sequence, delete customer table!
    @RequestMapping("deleteTableCustomer/{tableName}")
    fun deleteTableCustomer(@PathVariable tableName: String): ResponseEntity<*> {
        if (saveService.deleteTableCustomer(tableName)) {
            return ResponseEntity.ok(mapOf("OK" to "The customer table is removed from db!"))
        }
        return ResponseEntity.ok(mapOf("Error" to "Some error happened! the customer table not removed successfully!"))
    }

}