package com.example.marchseventh.entity.request

import com.example.marchseventh.entity.db.Customer
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * WebController manage service with GET, POST, and DELETE so far
 * @author      Yuanfeng Li
 * @version     2.0, 03/28/2022
 */
class SaveBody {
    private val customer: Customer

    @JsonCreator
    constructor(@JsonProperty("save") saveCustomer: Customer) {
        this.customer = saveCustomer
    }

    fun getSaveCustomer(): Customer {
        return customer
    }



}