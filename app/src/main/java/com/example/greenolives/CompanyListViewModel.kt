package com.example.greenolives

import androidx.lifecycle.ViewModel

class CompanyListViewModel : ViewModel() {
    val companies = mutableListOf<Company>()


    init {
        companies += Company(
            "Instamojo",
            "Full-stack platform for 1+ million MSMEs",
            "51-200 people",
            "Payments, Mobile Commerce",
            "Series B",
            4
        )

        companies += Company(
            "ixigo.com",
            "India's Mobile Travel Marketplace",
            "51-200 people",
            "Online Travel & Tourism",
            "Series B",
            5
        )

        companies += Company(
            "Unacademy",
            "India's largest free learning platform",
            "201-500 people",
            "Mobile Education"
        )

        companies += Company(
            "Nykaa.com",
            "India's premier online destination for beauty & wellness",
            "201-500 people",
            "E-Commerce, Beauty"
        )

        companies += Company(
            "Shuttl",
            "Bus-aggregating platform solving daily commute problems.",
            "201-500 people",
            "Mobile Transportation"
        )

        companies += Company(
            "Haptik",
            "One of the world's largest conversational AI platforms",
            "51-200 people",
            "Artificial Intelligence"
        )

        companies += Company(
            "Locus.sh",
            "Intelligent Logistics",
            "51-200 people",
            "E-Commerce Logistics, Hyperlocal Optimization"
        )

        companies += Company(
            "Swiggy",
            "Food Delivery 2.0 for India",
            "1001-5000 people",
            "Food and Beverages Logistics",
            "Series H",
            8
        )

        companies += Company(
            "EazyDiner",
            "Online Restaurant Reservations",
            "201-500 people",
            "Online Reservations, Restaurants E-Commerce"
        )

        companies += Company(
            "Craftsvilla.com",
            "Largest Online Ethnic Store with Strong funding",
            "51-200 people",
            "E-Commerce"
        )

        companies += Company(
            "Fynd",
            "Fresh Fashion, Straight From Brand Stores.",
            "51-200 people",
            "Mobile Fashion E-Commerce, Artificial Intelligence",
            "Series C",
            6

        )

        companies += Company(
            "smallcase",
            "Changing how India invests",
            "51-200 people",
            "Stocks, Financial Services, Personal Finance, Financial Technology"
        )

        companies += Company(
            "DocTalk (YC W17)",
            "Revolutionizing patient care while making doctors' lives better.",
            "1-10 people",
            "Market Healthcare"
        )

        companies += Company(
            "Skylark Drones",
            "Delivering drone solutions that matter",
            "11-50 people",
            "Infrastructure Monitoring, Utilities, Agriculture"
        )

        companies += Company(
            "Postman",
            "Postman is the leading collaboration platform for API development.",
            "51-200 people",
            "Developer Tools, SaaS, Web Development, Cloud Infrastructure"
        )

        companies += Company(
            "Testbook.com",
            "Exam Preparation Simplified",
            "51-200 people",
            "K-12 Education",
            "Series A",
            2
        )

        companies += Company(
            "Nanonets",
            "Machine Learning as a Service for Developers",
            "11-50 people",
            "Markets Machine Learning, Big Data"
        )

        companies += Company(
            "LogiNext",
            "Welcome To The World Of Organized Logistics and Field Service Management",
            "51-200 people",
            "Logistics Software, E-Commerce, Supply Chain Management"
        )

        companies += Company(
            "Kisan Network",
            "Y-Combinator and Thiel Foundation Backed Online Platform for Indian Agriculture",
            "51-200 people",
            "Agriculture, Mobile Commerce"
        )

        companies += Company(
            "Niki",
            "Niki is your local agent that helps you access services online.",
            "51-200 people",
            "Mobile Commerce, Natural Language Processing"
        )

        companies += Company(
            "HyperTrack",
            "Build applications that track the movement of your business",
            "11-50 people",
            "Mobile Maps, Location Based Services, Developer Tools"
        )

        companies += Company(
            "The Moms Co.",
            "Digital-first FMCG company on a mission to help Moms make Safe, Natural, Effective choices",
            "11-50 people",
            "Consumer Internet, Consumer Goods, Fast-Moving Consumer Goods"
        )

        companies += Company(
            "MobiKwik",
            "Digital Credit for the Masses of India",
            "201-500 people",
            "Mobile Payments, Consumer Lending, Fin Tech",
            "Series E",
            5
        )

        companies += Company(
            "Junglee Games",
            "The Fastest Growing Skill Games Company. 25 million+ users. $600M+ GMV",
            "201-500 people",
            "Mobile Games"
        )
    }
}

