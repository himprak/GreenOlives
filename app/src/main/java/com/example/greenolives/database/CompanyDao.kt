package com.example.greenolives.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.greenolives.Company
import java.util.*

@Dao
interface CompanyDao {

    @Query("SELECT * FROM company")
    fun getCompanies(): LiveData<List<Company>>

    @Query("SELECT * FROM company WHERE id=(:id)")
    fun getCompany(id: UUID): LiveData<Company?>

    @Update
    fun updateCompany(company: Company)

    @Insert
    fun addCompany(company: Company)
}