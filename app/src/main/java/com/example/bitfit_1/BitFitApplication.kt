package com.example.bitfit_1

import android.app.Application

class BitFitApplication : Application() {

    // Initialize database and repository
    val database by lazy { SleepDatabase.getDatabase(this) }
    val repository by lazy { SleepRepository(database.sleepDao()) }
}