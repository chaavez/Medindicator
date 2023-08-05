package com.example.medindicator.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.medindicator.R
import com.example.medindicator.databinding.ActivityMainBinding
import com.example.medindicator.features.add.medicines.AddMedicineFragment
import com.example.medindicator.features.adjusts.AdjustsFragment
import com.example.medindicator.features.historic.HistoricFragment
import com.example.medindicator.features.medicines.MedicinesFragment
import com.example.medindicator.features.schedules.SchedulesFragment

class MedindicatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(SchedulesFragment())
        initNavigation()
    }

    private fun initNavigation() {
        binding.mainBottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_schedule -> replaceFragment(SchedulesFragment())
                R.id.menu_medicines -> replaceFragment(MedicinesFragment())
                R.id.menu_add_medicine -> replaceFragment(AddMedicineFragment())
                R.id.menu_historic -> replaceFragment(HistoricFragment())
                R.id.menu_adjusts -> replaceFragment(AdjustsFragment())
                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_container, fragment)
            .commit()
    }
}