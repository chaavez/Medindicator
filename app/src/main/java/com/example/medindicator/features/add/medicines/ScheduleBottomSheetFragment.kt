package com.example.medindicator.features.add.medicines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medindicator.databinding.FragmentBottomSheetSchedulesBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ScheduleBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var _binding: FragmentBottomSheetSchedulesBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomSheetSchedulesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.bottomSheetRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

}