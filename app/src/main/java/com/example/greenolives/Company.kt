package com.example.greenolives

import java.util.*

data class Company (val id : UUID = UUID.randomUUID(),
               var name: String = "",
               var tagline: String = "",
               var specialization: String = "",
               var founders: String = "",
               var dateOfIncorporation: Date = Date(),
               var isFunded: Boolean = false,
               var fundingStatus: String = "",
               var numInvestors: Int = 0,
               var rating: Double = 0.0,
               var size: String = "") {
    constructor(name: String,
                tagline: String,
                size: String,
                specialization: String)
            : this(UUID.randomUUID(),
                   name,
                   tagline,
                   specialization,
                   "",
                   Date(),
                   false,
                   "",
                   0,
                   0.0,
                   size)
    constructor(name: String,
                tagline: String,
                size: String,
                specialization: String,
                fundingStatus: String,
                numInvestors: Int)
            : this(UUID.randomUUID(),
        name,
        tagline,
        specialization,
        "",
        Date(),
        true,
        fundingStatus,
        numInvestors,
        0.0,
        size)
}


