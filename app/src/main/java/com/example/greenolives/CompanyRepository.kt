package com.example.greenolives

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.greenolives.database.CompanyDatabase
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "company-database"

class CompanyRepository private constructor(context: Context) {

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

    companion object {

        private var INSTANCE: CompanyRepository? = null

        fun initialize(context: Context) {
            if(INSTANCE == null) {
                INSTANCE = CompanyRepository(context)
            }

            INSTANCE?.addCompany(Company(
                "Instamojo",
                "\"Full-stack platform for 1+ million MSMEs\"",
                "51-200 employees",
                "Payments",
                "Series B",
                4,
                "instamojo"
            ))

            INSTANCE?.addCompany(Company(
                "ixigo.com",
                "\"India's Mobile Travel Marketplace\"",
                "51-200 empolyees",
                "Online Travel & Tourism",
                "Series B",
                5,
                "ixigo"
            ))

            INSTANCE?.addCompany(Company(
                "Unacademy",
                "\"India's largest free learning platform\"",
                "201-500 empolyees",
                "Mobile Education",
                "unacademy"
            ))

            INSTANCE?.addCompany(Company(
                "Nykaa.com",
                "\"India's premier online destination for beauty & wellness\"",
                "201-500 empolyees",
                "E-Commerce, Beauty",
                "nykaa"
            ))

            INSTANCE?.addCompany(Company(
                "Shuttl",
                "\"Bus-aggregating platform solving daily commute problems\"",
                "201-500 empolyees",
                "Mobile Transportation",
                "shuttl"
            ))

            INSTANCE?.addCompany(Company(
                "Haptik",
                "\"Conversational AI platforms\"",
                "51-200 empolyees",
                "Artificial Intelligence",
                "haptik"
            ))

            INSTANCE?.addCompany(Company(
                "Locus.sh",
                "\"Intelligent Logistics\"",
                "51-200 empolyees",
                "E-Commerce Logistics",
                "locus"
            ))

            INSTANCE?.addCompany(Company(
                "Swiggy",
                "\"Food Delivery 2.0 for India\"",
                "1001-5000 empolyees",
                "Food and Beverages Logistics",
                "Series H",
                8,
                "swiggy"
            ))

            INSTANCE?.addCompany(Company(
                "EazyDiner",
                "\"Online Restaurant Reservations\"",
                "201-500 empolyees",
                "Online Reservations",
                "eazydiner"
            ))

            INSTANCE?.addCompany(Company(
                "Craftsvilla.com",
                "\"Fresh Designs Everyday!\"",
                "51-200 empolyees",
                "E-Commerce",
                "craftsvilla"
            ))

            INSTANCE?.addCompany(Company(
                "Fynd",
                "\"Fresh Fashion, Straight From Brand Stores\"",
                "51-200 empolyees",
                "Fashion E-Commerce, Artificial Intelligence",
                "Series C",
                6,
                "fynd"

            ))

            INSTANCE?.addCompany(Company(
                "smallcase",
                "\"Changing how India invests\"",
                "51-200 empolyees",
                "Personal Finance, Financial Technology",
                "smallcase"
            ))

            INSTANCE?.addCompany(Company(
                "DocTalk",
                "\"Revolutionizing patient care\"",
                "1-10 empolyees",
                "Healthcare",
                "doctalk"
            ))

            INSTANCE?.addCompany(Company(
                "Skylark Drones",
                "\"Delivering drone solutions that matter\"",
                "11-50 empolyees",
                "Infrastructure Monitoring, Agriculture",
                "skylark"
            ))

            INSTANCE?.addCompany(Company(
                "Postman",
                "\"Collaboration platform for API development\"",
                "51-200 empolyees",
                "Web Development, Cloud Infrastructure",
                "postman"
            ))

            INSTANCE?.addCompany(Company(
                "Testbook.com",
                "\"Exam Preparation Simplified\"",
                "51-200 empolyees",
                "K-12 Education",
                "Series A",
                2,
                "testbook"
            ))

            INSTANCE?.addCompany(Company(
                "Nanonets",
                "\"Machine Learning as a Service for Developers\"",
                "11-50 empolyees",
                "Machine Learning, Big Data",
                "nanonets"
            ))

            INSTANCE?.addCompany(Company(
                "LogiNext",
                "\"Organized Logistics and Field Service Management\"",
                "51-200 empolyees",
                "Logistics Software",
                "loginext"
            ))

            INSTANCE?.addCompany(Company(
                "Kisan Network",
                "\"Online Platform for Indian Agriculture\"",
                "51-200 empolyees",
                "Agriculture, Mobile Commerce",
                "kisan"
            ))

            INSTANCE?.addCompany(Company(
                "Niki",
                "\"Your local agent helping you access services online\"",
                "51-200 empolyees",
                "Natural Language Processing",
                "niki"
            ))

            INSTANCE?.addCompany(Company(
                "HyperTrack",
                "\"Build applications that track the movement of your business\"",
                "11-50 empolyees",
                "Location Based Services",
                "hypertrack"
            ))

            INSTANCE?.addCompany(Company(
                "The Moms Co.",
                "\"Helping Moms make Safe, Natural, Effective choices\"",
                "11-50 empolyees",
                "Consumer Internet, FMCG",
                "moms"
            ))

            INSTANCE?.addCompany(Company(
                "MobiKwik",
                "\"Digital Credit for the Masses of India\"",
                "201-500 empolyees",
                "Payments, Lending",
                "Series E",
                5,
                "mobikwik"
            ))

            INSTANCE?.addCompany(Company(
                "Junglee Games",
                "\"Skill Games!\"",
                "201-500 empolyees",
                "Mobile Games",
                "junglee"
            ))
        }

        fun get(): CompanyRepository {
            return INSTANCE ?:
                    throw IllegalStateException("CompanyRepository must be initialized")
        }
    }
}