package com.example.bitfit_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class AddEntryFragment : Fragment() {

    private lateinit var viewModel: SleepViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_entry, container, false)

        // Initialize ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(SleepViewModel::class.java)

        // Find views
        val hoursEditText = view.findViewById<EditText>(R.id.hoursEditText)
        val dateEditText = view.findViewById<EditText>(R.id.dateEditText)
        val saveButton = view.findViewById<Button>(R.id.saveButton)

        // Handle save button click
        saveButton.setOnClickListener {
            val hours = hoursEditText.text.toString().toDoubleOrNull() ?: 0.0
            val date = dateEditText.text.toString()

            if (date.isNotEmpty()) {
                // Create a new SleepEntry
                val entry = SleepEntry(hours = hours, date = date)

                // Insert the entry into the database
                viewModel.insert(entry)

                // Immediately show the RecyclerView and hide the FragmentContainer
                (requireActivity() as MainActivity).showRecyclerView()
            } else {
                // Show an error if the date is empty
                dateEditText.error = "Date cannot be empty"
            }
        }

        return view
    }
}