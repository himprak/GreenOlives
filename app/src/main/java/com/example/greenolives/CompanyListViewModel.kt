package com.example.greenolives

import androidx.lifecycle.ViewModel

class CompanyListViewModel : ViewModel() {
    private val companyRepository = CompanyRepository.get()
    val companyListLiveData = companyRepository.getCompanies()
}

