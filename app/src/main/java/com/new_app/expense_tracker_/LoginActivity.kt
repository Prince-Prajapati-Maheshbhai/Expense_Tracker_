package com.new_app.expense_tracker_

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val dataManager = DataManager(this)
        
        // Check if already logged in
        val currentUser = dataManager.getCurrentUser()
        if (currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        setContentView(R.layout.activity_login)

        val etUsername = findViewById<EditText>(R.id.editTextUsername)
        val etPassword = findViewById<EditText>(R.id.editTextPassword)
        val btnLogin = findViewById<Button>(R.id.buttonLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString()

            if (isValid(username, password)) {
                dataManager.setCurrentUser(username)
                Toast.makeText(this, "Login Successful! Welcome $username", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValid(user: String, pass: String): Boolean {
        return (user == "prince" && pass == "prince123") ||
               (user == "Prince1" && pass == "Prince1@123") ||
               (user == "admin" && pass == "admin123")
    }
}
