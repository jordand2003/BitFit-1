package com.example.bitfit_1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SleepViewModelFactory(private val repository: SleepRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SleepViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SleepViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}