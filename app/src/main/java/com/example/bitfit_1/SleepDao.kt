package com.example.bitfit_1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepDao {
    @Insert
    fun insert(entry: SleepEntry) // No suspend

    @Query("SELECT * FROM sleep_entries ORDER BY date DESC")
    fun getAllEntries(): Flow<List<SleepEntry>>

    @Query("SELECT COUNT(*) FROM sleep_entries")
    fun getEntryCount(): Int // Debugging query to check if data exists
}