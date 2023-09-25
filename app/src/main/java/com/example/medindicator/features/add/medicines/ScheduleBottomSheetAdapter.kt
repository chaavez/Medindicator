package com.example.medindicator.features.add.medicines

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medindicator.databinding.SchedulesListViewHolderBinding

class ScheduleBottomSheetAdapter(private var scheduleList: ArrayList<String>) : RecyclerView.Adapter<ScheduleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SchedulesListViewHolderBinding.inflate(inflater, parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun getItemCount() = scheduleList.size

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(scheduleList[position])
        holder.itemView.setOnClickListener {

        }
    }
}

class ScheduleViewHolder(private val binding: SchedulesListViewHolderBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(scheduleList: String) {
        binding.schedulesTextView.text = scheduleList
    }
}
