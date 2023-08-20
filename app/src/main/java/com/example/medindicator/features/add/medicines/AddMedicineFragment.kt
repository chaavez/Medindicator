package com.example.medindicator.features.add.medicines

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.medindicator.R
import com.example.medindicator.databinding.FragmentAddMedicineBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMenuItem()
    }

    override fun onResume() {
        super.onResume()
        setupDropDownMenu()
        setupDatePicker()
    }

    private fun setupMenuItem() {
        requireActivity().findViewById<BottomNavigationView>(R.id.main_bottom_navigation).apply {
            menu.findItem(R.id.menu_home).isChecked = true
        }
    }

    private fun setupDatePicker() {
        val myCalendar = Calendar.getInstance()

        val startDatePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(binding.startDateTextInputEditText, myCalendar)
        }

        binding.startDateTextInputEditText.setOnClickListener {
            DatePickerDialog(requireContext(), startDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    private fun updateLabel(dateTextInputEditText: TextInputEditText, myCalendar: Calendar) {
        val myFormat = "dd/MM/yyyy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.getDefault())
        dateTextInputEditText.setText(dateFormat.format(myCalendar.time))
    }

    private fun setupDropDownMenu() {
        val selectItems = listOf("1 dia", "3 dias", "7 dias", "15 dias")
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item_list, selectItems)
        binding.endAutoCompleteTextView.setAdapter(adapter)

        binding.endAutoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(requireContext(), "item $itemSelected", Toast.LENGTH_SHORT).show()
        }
    }
}