package com.example.medindicator.features.add.medicines

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.medindicator.R
import com.example.medindicator.databinding.FragmentAddMedicineBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
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
        setupDatePicker()
        setupDropDownMenu()
        setupNextButton()
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
            DatePickerDialog(
                requireContext(),
                startDatePicker,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun updateLabel(dateTextInputEditText: TextInputEditText, myCalendar: Calendar) {
        val myFormat = "dd/MM/yyyy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.getDefault())
        dateTextInputEditText.setText(dateFormat.format(myCalendar.time))
    }

    private fun parseDate(dateString: String): Date {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.parse(dateString) ?: Date()
    }

    private fun extractDaysFromSelectedItem(selectedItem: String): Int {
        val regex = Regex("""(\d+) dias?""").find(selectedItem)
        return regex?.groupValues?.getOrNull(1)?.toInt() ?: 0
    }

    private fun setupDropDownMenu() {
        binding.endAutoCompleteTextView.isEnabled = false
        binding.endDateTextInputLayout.isEnabled = false
        val selectItems = listOf("1 dia", "3 dias", "7 dias", "15 dias")
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item_list, selectItems)
        binding.endAutoCompleteTextView.setAdapter(adapter)

        binding.startDateTextInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                val startDateText = p0.toString()
                val startDateFilled = startDateText.isNotEmpty()
                binding.endAutoCompleteTextView.isEnabled = startDateFilled
                binding.endDateTextInputLayout.isEnabled = startDateFilled
            }
        })

        binding.endAutoCompleteTextView.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val itemSelected = adapterView.getItemAtPosition(i) as String
                val daysToAdd = extractDaysFromSelectedItem(itemSelected)
                val initialDateString = binding.startDateTextInputEditText.text.toString()
                val initialDate = parseDate(initialDateString)

                val calendar = Calendar.getInstance()
                calendar.time = initialDate
                val dateList = mutableListOf<Date>()

                for (day in 1..daysToAdd) {
                    dateList.add(calendar.time)
                    calendar.add(Calendar.DAY_OF_MONTH, 1)
                }
            }
    }

    private fun setupNextButton() {
        binding.nextButton.isEnabled = allFieldsFilled()
        binding.medicineTextInputEditText.addTextChangedListener(textWatcher())
        binding.dosageTextInputEditText.addTextChangedListener(textWatcher())
        binding.startDateTextInputEditText.addTextChangedListener(textWatcher())
        binding.endAutoCompleteTextView.addTextChangedListener(textWatcher())

        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_addMedicineFragment_to_scheduleFragment)
        }
    }

    private fun allFieldsFilled(): Boolean {
        val medicineText = binding.medicineTextInputEditText.text.toString()
        val dosageText = binding.dosageTextInputEditText.text.toString()
        val startDateText = binding.startDateTextInputEditText.text.toString()
        val endDateText = binding.endAutoCompleteTextView.text.toString()
        return medicineText.isNotEmpty() && dosageText.isNotEmpty()
                && startDateText.isNotEmpty() && endDateText.isNotEmpty()
    }

    private fun textWatcher(): TextWatcher {
        return object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                binding.nextButton.isEnabled = allFieldsFilled()
            }
        }
    }
}