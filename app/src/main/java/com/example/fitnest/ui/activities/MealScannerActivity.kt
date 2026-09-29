package com.example.fitnest.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnest.databinding.ActivityMealScannerBinding

class MealScannerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMealScannerBinding
    private var isFlashOn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        binding.btnFlash.setOnClickListener {
            isFlashOn = !isFlashOn
            val msg = if (isFlashOn) "Flash ON" else "Flash OFF"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        binding.btnCapture.setOnClickListener {
            Toast.makeText(this, "Scanning plate... 95% Match detected!", Toast.LENGTH_SHORT).show()
        }

        binding.btnGallery.setOnClickListener {
            Toast.makeText(this, "Choose photo from gallery", Toast.LENGTH_SHORT).show()
        }

        binding.btnSwitchMode.setOnClickListener {
            Toast.makeText(this, "Camera mode switched", Toast.LENGTH_SHORT).show()
        }

        binding.btnAddItem.setOnClickListener {
            Toast.makeText(this, "Add custom food item", Toast.LENGTH_SHORT).show()
        }

        binding.btnSaveMeal.setOnClickListener {
            Toast.makeText(this, "Meal saved! 620 kcal logged to your daily intake.", Toast.LENGTH_LONG).show()
            finish()
        }

        binding.btnEditResult.setOnClickListener {
            Toast.makeText(this, "Edit detected nutrients", Toast.LENGTH_SHORT).show()
        }
    }
}
