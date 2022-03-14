package com.example.marchseventh.entity.request

import com.example.marchseventh.entity.db.Customer
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

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