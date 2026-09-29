package com.example.fitnest.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnest.databinding.ActivityChallengesBinding

class ChallengesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChallengesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        binding.btnNotifications.setOnClickListener {
            startActivity(Intent(this, NotificationsActivity::class.java))
        }

        binding.btnLogSteps.setOnClickListener {
            Toast.makeText(this, "+1,000 steps logged! Keep moving.", Toast.LENGTH_SHORT).show()
        }

        binding.btnJoinProteinChallenge.setOnClickListener {
            binding.btnJoinProteinChallenge.text = "Joined! 🔥"
            binding.btnJoinProteinChallenge.isEnabled = false
            Toast.makeText(this, "Joined 14-day Protein Challenge!", Toast.LENGTH_SHORT).show()
        }

        binding.btnRenewHydration.setOnClickListener {
            Toast.makeText(this, "Hydration streak plan renewed for 30 days!", Toast.LENGTH_SHORT).show()
        }

        binding.btnUpgradeNow.setOnClickListener {
            Toast.makeText(this, "Welcome to FitNest Premium! Unlocking all challenges.", Toast.LENGTH_LONG).show()
        }
    }
}
