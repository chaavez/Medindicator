package com.example.medindicator.features.adjusts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medindicator.databinding.FragmentAdjustsBinding

class AdjustsFragment : Fragment() {
    private lateinit var _binding: FragmentAdjustsBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAdjustsBinding.inflate(inflater, container, false)
        return binding.root
    }

}