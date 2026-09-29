package com.example.fitnest.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.fitnest.R
import com.example.fitnest.databinding.ActivityExerciseDetailBinding

class ExerciseDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseDetailBinding
    private var isCompleted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getStringExtra("CATEGORY_NAME")
        if (category != null) {
            binding.tvExerciseTitle.text = "$category Workout - Bench Press"
        }

        binding.btnBack.setOnClickListener { finish() }

        binding.btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Barbell Bench Press Workout")
                putExtra(Intent.EXTRA_TEXT, "Crushed my Barbell Bench Press workout (4 sets, 8-12 reps) on FitNest!")
            }
            startActivity(Intent.createChooser(shareIntent, "Share Workout"))
        }

        binding.btnMarkCompleted.setOnClickListener {
            isCompleted = !isCompleted
            if (isCompleted) {
                binding.btnMarkCompleted.text = "Completed! 🎉"
                binding.btnMarkCompleted.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_dark))
                Toast.makeText(this, "Great job! Workout marked as complete.", Toast.LENGTH_SHORT).show()
            } else {
                binding.btnMarkCompleted.text = "Mark as Completed"
                binding.btnMarkCompleted.setBackgroundColor(ContextCompat.getColor(this, R.color.primary))
            }
        }
    }
}
