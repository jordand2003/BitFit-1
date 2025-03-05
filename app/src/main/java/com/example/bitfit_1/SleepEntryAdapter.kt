package com.example.bitfit_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SleepEntryAdapter : ListAdapter<SleepEntry, SleepEntryAdapter.ViewHolder>(SleepEntryDiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val hoursTextView: TextView = view.findViewById(R.id.hoursTextView)
        val dateTextView: TextView = view.findViewById(R.id.dateTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sleep_entry, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = getItem(position)
        holder.hoursTextView.text = "Hours: ${entry.hours}"
        holder.dateTextView.text = "Date: ${entry.date}"
    }

    class SleepEntryDiffCallback : DiffUtil.ItemCallback<SleepEntry>() {
        override fun areItemsTheSame(oldItem: SleepEntry, newItem: SleepEntry): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SleepEntry, newItem: SleepEntry): Boolean {
            return oldItem == newItem
        }
    }
}