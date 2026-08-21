package com.example.fitnest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val emailText = email.text.toString().trim()
            if (email.text.toString().isEmpty() || password.text.toString().isEmpty()) {
                Toast.makeText(
                    this,
                    "Please enter email and password",
                    Toast.LENGTH_SHORT
                ).show()
//                throw RuntimeException("Email or Password is Empty")
            } else {

                val name = emailText.substringBefore("@")
                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("USER_NAME", name)

                startActivity(intent)
                finish()
            }
        }
    }
}