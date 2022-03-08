package com.lyf_kotlin_prototype01.lyf_small_backend01.controller

import com.lyf_kotlin_prototype01.lyf_small_backend01.entity.database.UserEntity
import com.lyf_kotlin_prototype01.lyf_small_backend01.service.RegisterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
class RegisterController(@Autowired registerService: RegisterService) {
    val registerService: RegisterService = registerService

    @GetMapping("/uploadUser")
    // one input argument, that is the user object
//    fun uploadUser(@RequestBody var user: UserEntity) {   // bug1: can not use var in function
    fun uploadUser(@RequestBody user: UserEntity, response: HttpServletResponse) {
        // if 409 --> conflict happen return

        if (!registerService.register(user)) {
            response.status = HttpServletResponse.SC_CONFLICT
        }
    }

    @GetMapping("/downloaduser")
    fun downloadUser(@RequestBody user: UserEntity, response: HttpServletResponse) {

    }

}