package com.example.medindicator.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medindicator.R
import com.example.medindicator.databinding.FragmentHomeBinding
import com.example.medindicator.models.Mock

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val homeAdapter = HomeAdapter()
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        addMedicine()
    }

    private fun setupRecyclerView() {
        binding.scheduleRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.scheduleRecyclerView.adapter = homeAdapter
        setupMocks()
    }

    private fun setupMocks() {
        val mockData = Mock().mockData()
        homeAdapter.setSchedule(mockData)
    }

    private fun addMedicine() {
        binding.addFloatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_menu_home_to_addMedicineFragment)
        }
    }
}