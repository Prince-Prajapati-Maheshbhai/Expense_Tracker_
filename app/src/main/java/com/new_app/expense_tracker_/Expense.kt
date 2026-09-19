package com.new_app.expense_tracker_

import java.io.Serializable

// Serializable to allow passing between activities if needed
data class Expense(
    val name: String,
    val amount: Double,
    val category: String,
    val date: String
) : Serializable
