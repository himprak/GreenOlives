package com.example.greenolives.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.greenolives.Company

@Database(entities = [ Company::class ], version=1)
@TypeConverters(CompanyTypeConverters::class)
abstract class CompanyDatabase : RoomDatabase() {

    abstract fun companyDao(): CompanyDao
}