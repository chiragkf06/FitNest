package com.example.fitnest.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fitnest.R
import com.example.fitnest.databinding.FragmentProfileBinding
import com.example.fitnest.ui.activities.AchievementsActivity
import com.example.fitnest.ui.activities.ChallengesActivity
import com.example.fitnest.ui.activities.ProgressActivity
import com.example.fitnest.ui.activities.SettingsActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Menu Item 1: Progress
        binding.menuProgress.tvMenuTitle.text = "Progress"
        binding.menuProgress.ivMenuIcon.setImageResource(R.drawable.ic_trending_up)
        binding.menuProgress.root.setOnClickListener {
            startActivity(Intent(requireContext(), ProgressActivity::class.java))
        }

        // Setup Menu Item 2: Active Challenges
        binding.menuChallenges.tvMenuTitle.text = "Active Challenges"
        binding.menuChallenges.ivMenuIcon.setImageResource(R.drawable.ic_flag)
        binding.menuChallenges.root.setOnClickListener {
            startActivity(Intent(requireContext(), ChallengesActivity::class.java))
        }

        // Setup Menu Item 3: My Achievements
        binding.menuAchievements.tvMenuTitle.text = "My Achievements"
        binding.menuAchievements.ivMenuIcon.setImageResource(R.drawable.ic_emoji_events)
        binding.menuAchievements.root.setOnClickListener {
            startActivity(Intent(requireContext(), AchievementsActivity::class.java))
        }

        // Setup Menu Item 4: Settings
        binding.menuSettings.tvMenuTitle.text = "Settings"
        binding.menuSettings.ivMenuIcon.setImageResource(R.drawable.ic_settings)
        binding.menuSettings.root.setOnClickListener {
            startActivity(Intent(requireContext(), SettingsActivity::class.java))
        }

        // Setup Menu Item 5: Help & Support
        binding.menuHelp.tvMenuTitle.text = "Help & Support"
        binding.menuHelp.ivMenuIcon.setImageResource(R.drawable.ic_help)
        binding.menuHelp.root.setOnClickListener {
            Toast.makeText(requireContext(), "FitNest Support: support@fitnest.app", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
