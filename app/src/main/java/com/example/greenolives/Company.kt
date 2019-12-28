package com.example.greenolives

import java.util.*

data class Company (val id : UUID = UUID.randomUUID(),
               var name: String = "",
               var dateOfIncorporation: Date = Date(),
               var isFunded: Boolean = false)

