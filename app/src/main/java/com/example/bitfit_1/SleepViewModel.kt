package com.example.bitfit_1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SleepViewModel(private val repository: SleepRepository) : ViewModel() {

    val allEntries: Flow<List<SleepEntry>> = repository.allEntries

    fun insert(entry: SleepEntry) = viewModelScope.launch {
        repository.insert(entry)
    }

    fun logEntryCount() {
        viewModelScope.launch {
            val count = repository.getEntryCount()
            Log.d("SleepViewModel", "Database entry count: $count")
        }
    }
}