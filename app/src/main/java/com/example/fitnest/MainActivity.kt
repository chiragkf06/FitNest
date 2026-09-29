package com.example.fitnest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.fitnest.databinding.ActivityMainBinding
import com.example.fitnest.ui.fragments.DietFragment
import com.example.fitnest.ui.fragments.HomeFragment
import com.example.fitnest.ui.fragments.LeaderboardFragment
import com.example.fitnest.ui.fragments.ProfileFragment
import com.example.fitnest.ui.fragments.WorkoutFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val homeFragment = HomeFragment()
    private val workoutFragment = WorkoutFragment()
    private val dietFragment = DietFragment()
    private val leaderboardFragment = LeaderboardFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.bottomNavigationView) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                view.paddingLeft,
                view.paddingTop,
                view.paddingRight,
                systemBars.bottom
            )
            insets
        }

        if (savedInstanceState == null) {
            loadFragment(homeFragment)
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(homeFragment)
                    true
                }
                R.id.nav_workout -> {
                    loadFragment(workoutFragment)
                    true
                }
                R.id.nav_diet -> {
                    loadFragment(dietFragment)
                    true
                }
                R.id.nav_leaderboard -> {
                    loadFragment(leaderboardFragment)
                    true
                }
                R.id.nav_profile -> {
                    loadFragment(profileFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    fun selectNavigationTab(menuItemId: Int) {
        binding.bottomNavigationView.selectedItemId = menuItemId
    }
}
