package com.lyf_kotlin_prototype01.lyf_small_backend01.controller

import com.lyf_kotlin_prototype01.lyf_small_backend01.entity.database.UserEntity
import org.apache.catalina.User
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.http.HttpResponse
import javax.servlet.http.HttpServletResponse

@RestController
class HtmlController {

    @GetMapping("/")
    fun sayHello(content: Model): String {
        content["title"] = "Hello World"
        return "Hello World!!!!"
    }

    @GetMapping("/homepage")
    fun getHomePage() = "lyf_small_backend HomePage!!"

//    @GetMapping("/uploadUser")
//    // one input argument, that is the user object
////    fun uploadUser(@RequestBody var user: UserEntity) {   // bug1: can not use var in function
//    fun uploadUser(@RequestBody user: UserEntity, response: HttpServletResponse) {
//        // if 409 --> conflict happen return
//        if ()
//    }
//
//    @GetMapping("/downloaduser")
//    fun downloadUser(@RequestBody user: UserEntity, response: HttpServletResponse) {
//
//    }
}