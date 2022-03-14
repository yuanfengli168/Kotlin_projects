//package com.kotlination.jpapostgresql.model
package com.example.marchseventh.entity.db

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

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
@Table(name = "customer")   // postgre needs all lowercase, abbreviation for name
class Customer(
//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
//    var id: Long = -1,  // should be at 1st line
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DATA")
    @SequenceGenerator(sequenceName = "my_seq", allocationSize = 1, name = "SEQ_DATA")
    var id: Long,
    @Column(name = "first_name")
    @JsonProperty("first_name")
    var firstName: String = "",
    @JsonProperty("last_name")
    var lastName: String = ""

//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
//    var id: Long = -1   // should be at 1st line
)  // coding convention, an extra line