package com.example.fitnest.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnest.MainActivity
import com.example.fitnest.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter your email and password", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        binding.tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Password reset link sent to your email", Toast.LENGTH_SHORT).show()
        }

        binding.tvSignUp.setOnClickListener {
            Toast.makeText(this, "Sign Up option selected", Toast.LENGTH_SHORT).show()
        }
    }
}
