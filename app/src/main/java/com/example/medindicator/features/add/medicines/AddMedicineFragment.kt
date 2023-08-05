package com.example.medindicator.features.add.medicines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medindicator.databinding.FragmentAddMedicineBinding


class AddMedicineFragment : Fragment() {
    private lateinit var _binding: FragmentAddMedicineBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddMedicineBinding.inflate(inflater, container, false)
        return binding.root
    }

}