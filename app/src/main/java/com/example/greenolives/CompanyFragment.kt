package com.example.greenolives

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment

class CompanyFragment : Fragment() {

    private lateinit var company : Company
    private lateinit var nameField: EditText
    private lateinit var dateButton: Button
    private lateinit var fundedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        company = Company()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_company, container, false)
        nameField = view.findViewById(R.id.company_name) as EditText
        dateButton = view.findViewById(R.id.company_date) as Button

        dateButton.apply {
            text = company.dateOfIncorporation.toString()
            isEnabled = false
        }

        fundedCheckBox = view.findViewById(R.id.company_funded) as CheckBox
        return view
    }

    override fun onStart() {
        super.onStart()

        val nameWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                company.name = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        }

        nameField.addTextChangedListener(nameWatcher)

        fundedCheckBox.apply {
            setOnCheckedChangeListener { _, isChecked ->
                company.isFunded = isChecked

            }
        }
    }
}