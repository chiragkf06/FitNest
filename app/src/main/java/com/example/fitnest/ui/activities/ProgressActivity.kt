package com.example.fitnest.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.fitnest.R
import com.example.fitnest.databinding.ActivityProgressBinding

class ProgressActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProgressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        binding.btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "My FitNest Progress")
                putExtra(Intent.EXTRA_TEXT, "I completed 5 workouts and 74,650 steps this week with FitNest!")
            }
            startActivity(Intent.createChooser(shareIntent, "Share Progress"))
        }

        setupTabs()
    }

    private fun setupTabs() {
        val selectedBg = ContextCompat.getDrawable(this, R.drawable.bg_pill_green)
        val normalBg = ContextCompat.getDrawable(this, R.drawable.bg_pill_gray)
        val whiteColor = ContextCompat.getColor(this, R.color.white)
        val mutedColor = ContextCompat.getColor(this, R.color.text_secondary)

        fun updateTabs(selectedTab: View, period: String) {
            binding.tabWeek.background = if (selectedTab == binding.tabWeek) selectedBg else normalBg
            binding.tabWeek.setTextColor(if (selectedTab == binding.tabWeek) whiteColor else mutedColor)

            binding.tabMonth.background = if (selectedTab == binding.tabMonth) selectedBg else normalBg
            binding.tabMonth.setTextColor(if (selectedTab == binding.tabMonth) whiteColor else mutedColor)

            binding.tabYear.background = if (selectedTab == binding.tabYear) selectedBg else normalBg
            binding.tabYear.setTextColor(if (selectedTab == binding.tabYear) whiteColor else mutedColor)

            Toast.makeText(this, "Showing $period data", Toast.LENGTH_SHORT).show()
        }

        binding.tabWeek.setOnClickListener { updateTabs(it, "Weekly") }
        binding.tabMonth.setOnClickListener { updateTabs(it, "Monthly") }
        binding.tabYear.setOnClickListener { updateTabs(it, "Yearly") }
    }
}
