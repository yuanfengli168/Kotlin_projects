//package com.kotlination.jpapostgresql.model
package com.example.marchseventh.entity.db

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

/**
 * WebController manage service with GET, POST, and DELETE so far
 * @author      Yuanfeng Li
 * @version     2.0, 03/28/2022
 */
@Entity
@Table(name = "customer")   // postgres needs all lowercase, abbreviation for name
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DATA")
    @SequenceGenerator(sequenceName = "my_seq", allocationSize = 1, name = "SEQ_DATA")
    var id: Long,
    @Column(name = "first_name")
    @JsonProperty("first_name")
    var firstName: String = "",
    @JsonProperty("last_name")
    var lastName: String = "")