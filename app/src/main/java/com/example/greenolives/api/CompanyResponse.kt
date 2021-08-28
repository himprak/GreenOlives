package com.example.greenolives.api

import com.example.greenolives.Company
import com.google.gson.annotations.SerializedName

class CompanyResponse {
    @SerializedName("company")
    lateinit var companyItems: List<Company>
}