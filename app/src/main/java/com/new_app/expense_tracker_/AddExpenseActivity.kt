package com.new_app.expense_tracker_

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etAmount: EditText
    private lateinit var spinnerCategory: Spinner
    private lateinit var etDate: EditText
    private lateinit var btnSave: Button

    private lateinit var dataManager: DataManager
    private var currentUser: String? = null
    private var isEditMode = false
    private var expenseIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        dataManager = DataManager(this)
        currentUser = dataManager.getCurrentUser()

        etName = findViewById(R.id.etName)
        etAmount = findViewById(R.id.etAmount)
        spinnerCategory = findViewById(R.id.spinnerCategory)
        etDate = findViewById(R.id.etDate)
        btnSave = findViewById(R.id.btnSave)

        val categories = arrayOf("Food", "Travel", "Shopping", "Education", "Bills", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter

        etDate.setOnClickListener {
            showDatePicker()
        }

        isEditMode = intent.getBooleanExtra("isEdit", false)
        if (isEditMode) {
            expenseIndex = intent.getIntExtra("expenseIndex", -1)
            val expense = intent.getSerializableExtra("expenseObj") as? Expense
            expense?.let {
                etName.setText(it.name)
                etAmount.setText(it.amount.toString())
                etDate.setText(it.date)
                val pos = categories.indexOf(it.category)
                if (pos >= 0) spinnerCategory.setSelection(pos)
                btnSave.text = "Update Expense"
            }
        }

        btnSave.setOnClickListener {
            saveExpense()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(this, { _, year, month, day ->
            val dateStr = "$day-${month + 1}-$year"
            etDate.setText(dateStr)
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    private fun saveExpense() {
        val name = etName.text.toString().trim()
        val amountStr = etAmount.text.toString().trim()
        val category = spinnerCategory.selectedItem.toString()
        val date = etDate.text.toString().trim()

        if (name.isEmpty() || amountStr.isEmpty() || date.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val amount = amountStr.toDoubleOrNull()
        if (amount == null || amount <= 0) {
            Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
            return
        }

        currentUser?.let { user ->
            val expenses = dataManager.loadExpenses(user)
            val newExpense = Expense(name, amount, category, date)

            if (isEditMode && expenseIndex != -1) {
                expenses[expenseIndex] = newExpense
            } else {
                expenses.add(newExpense)
            }

            dataManager.saveExpenses(user, expenses)
            Toast.makeText(this, "Expense Saved", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
