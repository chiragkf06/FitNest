package com.example.fitnest.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnest.R
import com.example.fitnest.databinding.ActivityNotificationsBinding

class NotificationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        // Setup Notification 1: Workout Reminder
        binding.notifWorkout.tvNotifTitle.text = "Workout Reminder"
        binding.notifWorkout.tvNotifDescription.text = "It's time for your Chest Day"
        binding.notifWorkout.tvNotifTime.text = "1h ago"
        binding.notifWorkout.ivNotifIcon.setImageResource(R.drawable.ic_workout)
        binding.notifWorkout.root.setOnClickListener {
            startActivity(Intent(this, ExerciseDetailActivity::class.java))
        }

        // Setup Notification 2: New Achievement
        binding.notifAchievement.tvNotifTitle.text = "New Achievement"
        binding.notifAchievement.tvNotifDescription.text = "You earned 100 points for your 7-day streak"
        binding.notifAchievement.tvNotifTime.text = "3h ago"
        binding.notifAchievement.ivNotifIcon.setImageResource(R.drawable.ic_emoji_events)
        binding.notifAchievement.root.setOnClickListener {
            startActivity(Intent(this, AchievementsActivity::class.java))
        }

        // Setup Notification 3: Leaderboard Update
        binding.notifLeaderboard.tvNotifTitle.text = "Leaderboard Update"
        binding.notifLeaderboard.tvNotifDescription.text = "Rahul overtook you! Check the standings."
        binding.notifLeaderboard.tvNotifTime.text = "5h ago"
        binding.notifLeaderboard.ivNotifIcon.setImageResource(R.drawable.ic_leaderboard)
        binding.notifLeaderboard.root.setOnClickListener {
            Toast.makeText(this, "Check Leaderboard rankings in the Leaderboard tab!", Toast.LENGTH_SHORT).show()
        }

        // Setup Notification 4: Meal Reminder
        binding.notifMeal.tvNotifTitle.text = "Meal Reminder"
        binding.notifMeal.tvNotifDescription.text = "Don't forget to log your dinner"
        binding.notifMeal.tvNotifTime.text = "Yesterday"
        binding.notifMeal.ivNotifIcon.setImageResource(R.drawable.ic_diet)
        binding.notifMeal.root.setOnClickListener {
            startActivity(Intent(this, MealScannerActivity::class.java))
        }

        // Setup Notification 5: Hydration
        binding.notifHydration.tvNotifTitle.text = "Hydration"
        binding.notifHydration.tvNotifDescription.text = "Have you had your water? Stay hydrated."
        binding.notifHydration.tvNotifTime.text = "Yesterday"
        binding.notifHydration.ivNotifIcon.setImageResource(R.drawable.ic_water_drop)
        binding.notifHydration.root.setOnClickListener {
            Toast.makeText(this, "Water logged: 250ml added!", Toast.LENGTH_SHORT).show()
        }
    }
}
