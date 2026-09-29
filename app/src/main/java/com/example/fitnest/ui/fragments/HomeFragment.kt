package com.example.fitnest.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fitnest.MainActivity
import com.example.fitnest.R
import com.example.fitnest.databinding.FragmentHomeBinding
import com.example.fitnest.ui.activities.ExerciseDetailActivity
import com.example.fitnest.ui.activities.NotificationsActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.circularProgressRing.setProgress(75f)

        // Notification bell button
        binding.btnNotifications.setOnClickListener {
            val intent = Intent(requireContext(), NotificationsActivity::class.java)
            startActivity(intent)
        }

        // Today's workout Start button
        binding.btnStartWorkout.setOnClickListener {
            val intent = Intent(requireContext(), ExerciseDetailActivity::class.java)
            startActivity(intent)
        }

        // Today's workout card click
        binding.cardTodayWorkout.setOnClickListener {
            val intent = Intent(requireContext(), ExerciseDetailActivity::class.java)
            startActivity(intent)
        }

        // View All click -> switch to Workout tab
        binding.tvWorkoutViewAll.setOnClickListener {
            (activity as? MainActivity)?.selectNavigationTab(R.id.nav_workout)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
