package com.example.greenolives.api

import retrofit2.Call
import retrofit2.http.GET


interface CompanyApi {

    @GET("/")
    fun fetchContents() : Call<String>
}