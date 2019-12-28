package com.example.greenolives

import androidx.lifecycle.ViewModel

class CompanyListViewModel : ViewModel() {
    val companies = mutableListOf<Company>()

    init {
        for(i in 0 until 100) {
            val company = Company()
            company.name = "Company #$i"
            company.isFunded = i % 2 == 0
            companies += company
        }
    }
}