//package com.kotlination.jpapostgresql.model
package com.example.marchseventh.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

// // since we have no-arg in dependency, it will be ok if we can use this as no-arg!
//@Entity
//class Customer(
//    val firstName: String,
//    val lastName: String,
//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
//    val id: Long = -1) {
//
//    private constructor() : this("", "")
//}

@Entity
open class Customer(
    var firstName: String = "",
    var lastName: String = "",
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1)