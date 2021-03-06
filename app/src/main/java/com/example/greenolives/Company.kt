package com.example.greenolives

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Company (@PrimaryKey val id : UUID = UUID.randomUUID(),
                    var name: String = "",
                    var tagline: String = "",
                    var specialization: String = "",
                    var founders: String = "",
                    var dateOfIncorporation: Date = Date(),
                    var isFunded: Boolean = false,
                    var fundingStatus: String = "",
                    var numInvestors: Int = 0,
                    var rating: Double = 0.0,
                    var size: String = "",
                    var image: String = "greenolives",
                    var keyInvestors: String = "",
                    var totalFunding: String = "",
                    var about: String = "") {
    constructor(name: String,
                tagline: String,
                size: String,
                specialization: String,
                image: String = "greenolives")
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
                   size,
                   image)

    constructor(name: String,
                tagline: String,
                size: String,
                specialization: String,
                fundingStatus: String,
                numInvestors: Int,
                image: String = "greenolives")
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
                   size,
                   image)
}


