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
import org.apache.coyote.Request
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * WebController manage service with GET, POST, and DELETE so far
 * @author      Yuanfeng Li
 * @version     2.0, 03/28/2022
 */
@RestController
class WebController {
    @Autowired
    lateinit var saveService: SaveService

    @RequestMapping(path = ["/customer"], method = [RequestMethod.POST])
    fun save(@RequestBody saveBody: SaveBody, response: HttpServletResponse): ResponseEntity<*> {
        if (!saveService.save(saveBody)) {
            return ResponseEntity.ok(mapOf("Message" to "There existed one in db, please adjust!"))
        }
        return ResponseEntity.ok(mapOf("Message" to "Your request hase inserted to the database!"))
    }




    // customer/All -> 这里就用来和别人的区分
    @RequestMapping(path = ["customers"], method = [RequestMethod.GET])
    fun findAll(): List<*> {
        return saveService.findAll()
        // TODO: verification
    }

    @RequestMapping(path = ["customers"], method = [RequestMethod.GET], params = ["firstName"])
    fun findByFirstName(@RequestParam("firstName") firstName: String) = saveService.findByFirstName(firstName)









    @RequestMapping(path = ["customer"], method = [RequestMethod.GET], params = ["id"])
    fun findById(@RequestParam("id") id: Long) = saveService.findById(id)

    @RequestMapping(path = ["customers"], method = [RequestMethod.GET], params = ["lastName"])
    fun findByLastName(@RequestParam("lastName") lastName: String) = saveService.findByLastName(lastName)



    @RequestMapping(path = ["customers"], method = [RequestMethod.DELETE])
    fun truncateAll(): ResponseEntity<*> {
        saveService.truncateAll()
        return ResponseEntity.ok(mapOf("message" to "Has truncated all customers in the table!"))
    }

    @RequestMapping(path = ["customer"], method = [RequestMethod.DELETE], params = ["deleteId"])
    fun truncateById(@RequestParam("deleteId") deleteId: Long) : ResponseEntity<*> {
        if (!saveService.truncateById(deleteId)) {
            return ResponseEntity.ok(mapOf("error" to "can't delete $deleteId in db, something went wrong!"))
        }
        return ResponseEntity.ok(mapOf("message" to "deleted $deleteId in db!"))
    }

}