package com.new_app.expense_tracker_

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dataManager: DataManager
    private var currentUser: String? = null
    private var expenseList = mutableListOf<Expense>()

    private lateinit var tvWelcome: TextView
    private lateinit var tvTotalAmount: TextView
    private lateinit var layoutExpenses: LinearLayout
    private lateinit var layoutCategorySummary: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataManager = DataManager(this)
        currentUser = dataManager.getCurrentUser()

        if (currentUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }

        setContentView(R.layout.activity_main)

        tvWelcome = findViewById(R.id.tvWelcome)
        tvTotalAmount = findViewById(R.id.tvTotalAmount)
        layoutExpenses = findViewById(R.id.layoutExpenses)
        layoutCategorySummary = findViewById(R.id.layoutCategorySummary)

        tvWelcome.text = "Welcome, $currentUser"

        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            dataManager.logout()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        findViewById<Button>(R.id.btnAddExpense).setOnClickListener {
            startActivity(Intent(this, AddExpenseActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        refreshDashboard()
    }

    private fun refreshDashboard() {
        currentUser?.let { user ->
            expenseList = dataManager.loadExpenses(user)
            updateTotalAndSummary()
            displayExpenses()
        }
    }

    private fun updateTotalAndSummary() {
        var total = 0.0
        val summaryMap = mutableMapOf<String, Double>()
        val categories = listOf("Food", "Travel", "Shopping", "Education", "Bills", "Other")

        for (cat in categories) {
            summaryMap[cat] = 0.0
        }

        for (expense in expenseList) {
            total += expense.amount
            val currentCatAmount = summaryMap[expense.category] ?: 0.0
            summaryMap[expense.category] = currentCatAmount + expense.amount
        }

        tvTotalAmount.text = "₹" + String.format("%.2f", total)

        layoutCategorySummary.removeAllViews()
        for (cat in categories) {
            val amount = summaryMap[cat] ?: 0.0
            val tv = TextView(this)
            tv.text = "$cat: ₹" + String.format("%.2f", amount)
            tv.textSize = 16f
            tv.setPadding(0, 8, 0, 8)
            layoutCategorySummary.addView(tv)
        }
    }

    private fun displayExpenses() {
        layoutExpenses.removeAllViews()
        val inflater = LayoutInflater.from(this)

        for (i in expenseList.indices) {
            val expense = expenseList[i]
            val itemView = inflater.inflate(R.layout.expense_item, layoutExpenses, false)

            itemView.findViewById<TextView>(R.id.tvItemName).text = expense.name
            itemView.findViewById<TextView>(R.id.tvItemCategoryDate).text = expense.category + " | " + expense.date
            itemView.findViewById<TextView>(R.id.tvItemAmount).text = "₹" + expense.amount

            itemView.findViewById<ImageButton>(R.id.btnEdit).setOnClickListener {
                val intent = Intent(this, AddExpenseActivity::class.java)
                intent.putExtra("isEdit", true)
                intent.putExtra("expenseIndex", i)
                intent.putExtra("expenseObj", expense)
                startActivity(intent)
            }

            itemView.findViewById<ImageButton>(R.id.btnDelete).setOnClickListener {
                showDeleteConfirmation(i)
            }

            layoutExpenses.addView(itemView)
        }
    }

    private fun showDeleteConfirmation(index: Int) {
        AlertDialog.Builder(this)
            .setTitle("Delete Expense")
            .setMessage("Are you sure you want to delete this expense?")
            .setPositiveButton("Delete") { _, _ ->
                expenseList.removeAt(index)
                currentUser?.let { dataManager.saveExpenses(it, expenseList) }
                refreshDashboard()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}