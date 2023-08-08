package com.example.medindicator.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medindicator.databinding.ScheduleViewHolderBinding
import com.example.medindicator.models.Schedule
import java.util.ArrayList

class HomeAdapter(private var schedule: List<Schedule> = ArrayList()): RecyclerView.Adapter<ScheduleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ScheduleViewHolderBinding.inflate(inflater, parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun getItemCount() = schedule.size

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(schedule[position])
    }

    fun setSchedule(schedule: List<Schedule>) {
        this.schedule = schedule
        notifyDataSetChanged()
    }
}

class ScheduleViewHolder(private val binding: ScheduleViewHolderBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(schedule: Schedule) {
        binding.dosageTextView.text = schedule.dosage
        binding.scheduleTextView.text = schedule.time
        binding.medicineTitleTextView.text = schedule.name
    }
}