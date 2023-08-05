package com.example.medindicator.features.schedules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medindicator.databinding.FragmentSchedulesBinding

class SchedulesFragment : Fragment() {

    private lateinit var _binding: FragmentSchedulesBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSchedulesBinding.inflate(inflater, container, false)
        return binding.root
    }
}