package com.example.greenolives

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*

class CompanyDetailViewModel : ViewModel() {

    private val companyRepository = CompanyRepository.get()
    private val companyIdLiveData = MutableLiveData<UUID>()
    val companyLiveDataHttp: LiveData<String> = companyRepository.fetchContents()

    var companyLiveData: LiveData<Company?> =
        Transformations.switchMap(companyIdLiveData) { companyId ->
            companyRepository.getCompany(companyId)
        }

    fun loadCompany(companyId: UUID) {
        companyIdLiveData.value = companyId
    }

    fun saveCompany(company: Company) {
        companyRepository.updateCompany(company)
    }
}