package com.example.bitfit_1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep_entries")
data class SleepEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val hours: Double,
    val date: String
)