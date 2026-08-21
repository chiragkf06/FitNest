package com.example.fitnest

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_student_detail)

        val nameText = findViewById<TextView>(R.id.nameText)
        val descText = findViewById<TextView>(R.id.descText)
        val backButton = findViewById<Button>(R.id.backButton)

        val name = intent.getStringExtra("STUDENT_NAME")
        val desc = intent.getStringExtra("STUDENT_DESCRIPTION")
        nameText.text = "Student: $name"
        descText.text = desc

        backButton.setOnClickListener {
            finish()
        }
    }
}