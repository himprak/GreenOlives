package com.example.greenolives

import android.app.Application

class GreenOlivesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CompanyRepository.initialize(this)
    }
}