package com.example.bitfit_1

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bitfit_1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: SleepViewModel by viewModels {
        SleepViewModelFactory((application as BitFitApplication).repository)
    }

    private lateinit var adapter: SleepEntryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView and Adapter
        adapter = SleepEntryAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe data from ViewModel
        lifecycleScope.launch {
            viewModel.allEntries.collect { entries ->
                adapter.submitList(entries) // Update the adapter with new data
            }
        }

        // Handle "Add Entry" button click
        binding.addButton.setOnClickListener {
            showAddEntryFragment()
        }
    }

    private fun showAddEntryFragment() {
        // Hide RecyclerView and show FragmentContainer
        binding.recyclerView.visibility = View.GONE
        binding.fragmentContainer.visibility = View.VISIBLE

        // Replace FragmentContainer with AddEntryFragment
        supportFragmentManager.commit {
            replace(R.id.fragment_container, AddEntryFragment())
            addToBackStack(null)
        }
    }

    // Public method to show RecyclerView
    fun showRecyclerView() {
        // Show RecyclerView and hide FragmentContainer
        binding.recyclerView.visibility = View.VISIBLE
        binding.fragmentContainer.visibility = View.GONE
    }
}