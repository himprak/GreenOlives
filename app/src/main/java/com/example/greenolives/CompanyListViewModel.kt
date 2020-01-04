package com.example.greenolives

import androidx.lifecycle.ViewModel

class CompanyListViewModel : ViewModel() {
    private val companyRepository = CompanyRepository.get()
    val companyListLiveData = companyRepository.getCompanies()

    //val companies = mutableListOf<Company>()

    /*init {
        companies += Company(
            "Instamojo",
            "\"Full-stack platform for 1+ million MSMEs\"",
            "51-200 employees",
            "Payments",
            "Series B",
            4,
            "instamojo"
        )

        companies += Company(
            "ixigo.com",
            "\"India's Mobile Travel Marketplace\"",
            "51-200 empolyees",
            "Online Travel & Tourism",
            "Series B",
            5,
            "ixigo"
        )

        companies += Company(
            "Unacademy",
            "\"India's largest free learning platform\"",
            "201-500 empolyees",
            "Mobile Education",
            "unacademy"
        )

        companies += Company(
            "Nykaa.com",
            "\"India's premier online destination for beauty & wellness\"",
            "201-500 empolyees",
            "E-Commerce, Beauty",
            "nykaa"
        )

        companies += Company(
            "Shuttl",
            "\"Bus-aggregating platform solving daily commute problems\"",
            "201-500 empolyees",
            "Mobile Transportation",
            "shuttl"
        )

        companies += Company(
            "Haptik",
            "\"Conversational AI platforms\"",
            "51-200 empolyees",
            "Artificial Intelligence",
            "haptik"
        )

        companies += Company(
            "Locus.sh",
            "\"Intelligent Logistics\"",
            "51-200 empolyees",
            "E-Commerce Logistics",
            "locus"
        )

        companies += Company(
            "Swiggy",
            "\"Food Delivery 2.0 for India\"",
            "1001-5000 empolyees",
            "Food and Beverages Logistics",
            "Series H",
            8,
            "swiggy"
        )

        companies += Company(
            "EazyDiner",
            "\"Online Restaurant Reservations\"",
            "201-500 empolyees",
            "Online Reservations",
            "eazydiner"
        )

        companies += Company(
            "Craftsvilla.com",
            "\"Fresh Designs Everyday!\"",
            "51-200 empolyees",
            "E-Commerce",
            "craftsvilla"
        )

        companies += Company(
            "Fynd",
            "\"Fresh Fashion, Straight From Brand Stores\"",
            "51-200 empolyees",
            "Fashion E-Commerce, Artificial Intelligence",
            "Series C",
            6,
            "fynd"

        )

        companies += Company(
            "smallcase",
            "\"Changing how India invests\"",
            "51-200 empolyees",
            "Personal Finance, Financial Technology",
            "smallcase"
        )

        companies += Company(
            "DocTalk",
            "\"Revolutionizing patient care\"",
            "1-10 empolyees",
            "Healthcare",
            "doctalk"
        )

        companies += Company(
            "Skylark Drones",
            "\"Delivering drone solutions that matter\"",
            "11-50 empolyees",
            "Infrastructure Monitoring, Agriculture",
            "skylark"
        )

        companies += Company(
            "Postman",
            "\"Collaboration platform for API development\"",
            "51-200 empolyees",
            "Web Development, Cloud Infrastructure",
            "postman"
        )

        companies += Company(
            "Testbook.com",
            "\"Exam Preparation Simplified\"",
            "51-200 empolyees",
            "K-12 Education",
            "Series A",
            2,
            "testbook"
        )

        companies += Company(
            "Nanonets",
            "\"Machine Learning as a Service for Developers\"",
            "11-50 empolyees",
            "Machine Learning, Big Data",
            "nanonets"
        )

        companies += Company(
            "LogiNext",
            "\"Organized Logistics and Field Service Management\"",
            "51-200 empolyees",
            "Logistics Software",
            "loginext"
        )

        companies += Company(
            "Kisan Network",
            "\"Online Platform for Indian Agriculture\"",
            "51-200 empolyees",
            "Agriculture, Mobile Commerce",
            "kisan"
        )

        companies += Company(
            "Niki",
            "\"Your local agent helping you access services online\"",
            "51-200 empolyees",
            "Natural Language Processing",
            "niki"
        )

        companies += Company(
            "HyperTrack",
            "\"Build applications that track the movement of your business\"",
            "11-50 empolyees",
            "Location Based Services",
            "hypertrack"
        )

        companies += Company(
            "The Moms Co.",
            "\"Helping Moms make Safe, Natural, Effective choices\"",
            "11-50 empolyees",
            "Consumer Internet, FMCG",
            "moms"
        )

        companies += Company(
            "MobiKwik",
            "\"Digital Credit for the Masses of India\"",
            "201-500 empolyees",
            "Payments, Lending",
            "Series E",
            5,
            "mobikwik"
        )

        companies += Company(
            "Junglee Games",
            "\"Skill Games!\"",
            "201-500 empolyees",
            "Mobile Games",
            "junglee"
        )
    }*/
}

