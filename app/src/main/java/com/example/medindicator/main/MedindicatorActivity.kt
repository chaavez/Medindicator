package com.example.medindicator.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.medindicator.R
import com.example.medindicator.databinding.ActivityMainBinding
import com.example.medindicator.features.add.medicines.AddMedicineFragment
import com.example.medindicator.features.adjusts.AdjustsFragment
import com.example.medindicator.features.historic.HistoricFragment
import com.example.medindicator.features.medicines.MedicinesFragment
import com.example.medindicator.features.schedules.SchedulesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MedindicatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
    }

    private fun initNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.mainBottomNavigation, navController)
        binding.mainBottomNavigation.setOnItemReselectedListener {
            navController.currentDestination
        }
    }
}