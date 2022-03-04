package com.lyf_kotlin_prototype01.lyf_small_backend01.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HtmlController {

    @GetMapping("/")
    fun sayHello(content: Model): String {
        content["title"] = "Hello World"
        return "Hello World Returned!"
    }

    @GetMapping("/homepage")
    fun getHomePage() = "NFTs Marketplace"
}