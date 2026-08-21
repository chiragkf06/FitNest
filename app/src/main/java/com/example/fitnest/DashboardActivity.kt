package com.example.fitnest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java

class DashboardActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val helloText = findViewById<TextView>(R.id.helloText)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        val name = intent.getStringExtra("USER_NAME")
        helloText.text = "Hello, ${name?.replaceFirstChar { it.uppercase() }}!"

        logoutButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            finish()
        }

        val studentsButton = findViewById<Button>(R.id.studentsButton)

        studentsButton.setOnClickListener {
            val intent = Intent(this, StudentListActivity::class.java)
            startActivity(intent)
        }
    }
}