package com.lyf_kotlin_prototype01.lyf_small_backend01.entity.database

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name="users")
// need to declare the kotlin be open, since by default kotlin classes are final.
open class UserEntity {

    @get:Id
    @get:GeneratedValue
    @get:Column(name="user_id")
    open var id: Int? = null

    @get:Column(name="user_name")
    open var name: String? = null
}