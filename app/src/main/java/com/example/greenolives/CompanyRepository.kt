package com.example.greenolives

import android.content.Context
import android.util.Log
import androidx.core.util.rangeTo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.greenolives.api.ApiResponse
import com.example.greenolives.database.CompanyDatabase
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors
import com.example.greenolives.api.CompanyApi
import com.example.greenolives.api.CompanyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "CompanyRepository"
private const val DATABASE_NAME = "company-database"

class CompanyRepository private constructor(context: Context) {

    private val companyApi: CompanyApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://34.131.60.146:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        companyApi = retrofit.create(CompanyApi::class.java)
    }

    fun fetchCompanies(): List<Company>? {
        var companyItems: List<Company>? = listOf<Company>()
        val companyRequest: Call<ApiResponse> = companyApi.fetchContents()

        companyRequest.enqueue(object: Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e(TAG, "Failed to execute company api", t)
            }

            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {
                val apiResponse: ApiResponse? = response.body()
                val companyResponse: CompanyResponse? = apiResponse?.companies
                companyItems = companyResponse?.companyItems
                Log.d(TAG, "Response received ${companyItems}")
                for (company in companyItems!!) {
                    addCompany(company)
                }
            }
        })

        return companyItems
    }

    private val database : CompanyDatabase = Room.databaseBuilder(
        context.applicationContext,
        CompanyDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val companyDao = database.companyDao()

    private val executor = Executors.newSingleThreadExecutor()

    fun getCompanies(): LiveData<List<Company>> = companyDao.getCompanies()

    fun getCompany(id: UUID): LiveData<Company?> = companyDao.getCompany(id)

    fun updateCompany(company: Company) {
        executor.execute {
            companyDao.updateCompany(company)
        }
    }

    fun addCompany(company: Company) {
        executor.execute {
            companyDao.addCompany(company)
        }
    }

    fun clearCompanies() {
        executor.execute {
            companyDao.clearCompanies()
        }
    }

    companion object {

        private var INSTANCE: CompanyRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CompanyRepository(context)
            }

            INSTANCE?.clearCompanies()

            INSTANCE?.fetchCompanies()
        }

        fun get(): CompanyRepository {
            return INSTANCE ?:
                    throw IllegalStateException("CompanyRepository must be initialized")
        }
    }
}