package com.example.medindicator.features.medicines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medindicator.databinding.FragmentMedicinesBinding

class MedicinesFragment : Fragment() {
    private lateinit var _binding: FragmentMedicinesBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMedicinesBinding.inflate(inflater, container, false)
        return binding.root
    }
}