package com.new_app.expense_tracker_

import android.content.Context
import android.content.SharedPreferences
import org.json.JSONArray
import org.json.JSONObject

class DataManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("ExpenseTrackerPrefs", Context.MODE_PRIVATE)

    // Save list of expenses for a specific user
    fun saveExpenses(username: String, expenses: List<Expense>) {
        val jsonArray = JSONArray()
        for (expense in expenses) {
            val jsonObject = JSONObject()
            jsonObject.put("name", expense.name)
            jsonObject.put("amount", expense.amount)
            jsonObject.put("category", expense.category)
            jsonObject.put("date", expense.date)
            jsonArray.put(jsonObject)
        }
        sharedPreferences.edit().putString("expenses_$username", jsonArray.toString()).apply()
    }

    // Load list of expenses for a specific user
    fun loadExpenses(username: String): MutableList<Expense> {
        val expenses = mutableListOf<Expense>()
        val jsonString = sharedPreferences.getString("expenses_$username", null)
        if (jsonString != null) {
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                expenses.add(
                    Expense(
                        jsonObject.getString("name"),
                        jsonObject.getDouble("amount"),
                        jsonObject.getString("category"),
                        jsonObject.getString("date")
                    )
                )
            }
        }
        return expenses
    }

    // Session management
    fun setCurrentUser(username: String) {
        sharedPreferences.edit().putString("current_user", username).apply()
    }

    fun getCurrentUser(): String? {
        return sharedPreferences.getString("current_user", null)
    }

    fun logout() {
        sharedPreferences.edit().remove("current_user").apply()
    }
}
