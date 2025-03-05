package com.example.bitfit_1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class SleepRepository(private val sleepDao: SleepDao) {

    val allEntries: Flow<List<SleepEntry>> = sleepDao.getAllEntries()

    suspend fun insert(entry: SleepEntry) {
        withContext(Dispatchers.IO) {
            sleepDao.insert(entry)
        }
    }

    suspend fun getEntryCount(): Int {
        return withContext(Dispatchers.IO) {
            sleepDao.getEntryCount()
        }
    }
}