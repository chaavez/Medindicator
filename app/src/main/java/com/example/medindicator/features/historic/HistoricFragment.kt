package com.example.medindicator.features.historic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medindicator.databinding.FragmentHistoricBinding

class HistoricFragment : Fragment() {
    private lateinit var _binding: FragmentHistoricBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoricBinding.inflate(inflater, container, false)
        return binding.root
    }

}