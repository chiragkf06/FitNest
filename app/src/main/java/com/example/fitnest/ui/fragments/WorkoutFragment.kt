package com.example.fitnest.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnest.R
import com.example.fitnest.databinding.FragmentWorkoutBinding
import com.example.fitnest.model.WorkoutCategory
import com.example.fitnest.ui.activities.ExerciseDetailActivity
import com.example.fitnest.ui.activities.NotificationsActivity
import com.example.fitnest.ui.adapters.WorkoutCategoryAdapter

class WorkoutFragment : Fragment() {

    private var _binding: FragmentWorkoutBinding? = null
    private val binding get() = _binding!!

    private val gymWorkouts = listOf(
        WorkoutCategory("1", "Chest & Triceps", "6 Exercises", R.drawable.ic_workout),
        WorkoutCategory("2", "Back & Biceps", "5 Exercises", R.drawable.ic_workout),
        WorkoutCategory("3", "Legs & Calves", "6 Exercises", R.drawable.ic_workout),
        WorkoutCategory("4", "Shoulders & Traps", "5 Exercises", R.drawable.ic_workout),
        WorkoutCategory("5", "Arms Blast", "6 Exercises", R.drawable.ic_workout),
        WorkoutCategory("6", "Core & Abs", "4 Exercises", R.drawable.ic_workout),
        WorkoutCategory("7", "Treadmill & Cardio", "30 mins", R.drawable.ic_directions_walk)
    )

    private val homeWorkouts = listOf(
        WorkoutCategory("101", "Bodyweight Push-ups & Dips", "4 Exercises", R.drawable.ic_workout),
        WorkoutCategory("102", "Resistance Band Back & Pull", "5 Exercises", R.drawable.ic_workout),
        WorkoutCategory("103", "Bodyweight Squats & Lunges", "5 Exercises", R.drawable.ic_workout),
        WorkoutCategory("104", "Dumbbell Shoulder Press", "4 Exercises", R.drawable.ic_workout),
        WorkoutCategory("105", "Home Biceps & Triceps", "4 Exercises", R.drawable.ic_workout),
        WorkoutCategory("106", "Plank & Core Burner", "5 Exercises", R.drawable.ic_workout),
        WorkoutCategory("107", "Jumping Jacks & HIIT Cardio", "20 mins", R.drawable.ic_directions_walk)
    )

    private val myPlanWorkouts = listOf(
        WorkoutCategory("201", "Morning Energy Routine", "15 mins", R.drawable.ic_workout),
        WorkoutCategory("202", "High Intensity Fat Burn", "25 mins", R.drawable.ic_directions_walk),
        WorkoutCategory("203", "Core & Stability Strength", "20 mins", R.drawable.ic_workout),
        WorkoutCategory("204", "Full Body Muscle Sculpt", "40 mins", R.drawable.ic_workout),
        WorkoutCategory("205", "Flexibility & Active Recovery", "15 mins", R.drawable.ic_directions_walk)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvWorkouts.layoutManager = LinearLayoutManager(requireContext())
        displayWorkouts(gymWorkouts)

        setupTabs()

        binding.btnNotifications.setOnClickListener {
            val intent = Intent(requireContext(), NotificationsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupTabs() {
        val selectedBg = ContextCompat.getDrawable(requireContext(), R.drawable.bg_pill_green)
        val normalBg = ContextCompat.getDrawable(requireContext(), R.drawable.bg_pill_gray)
        val whiteColor = ContextCompat.getColor(requireContext(), R.color.white)
        val mutedColor = ContextCompat.getColor(requireContext(), R.color.text_secondary)

        fun updateTabs(selectedTab: View) {
            binding.tabGym.background = if (selectedTab == binding.tabGym) selectedBg else normalBg
            binding.tabGym.setTextColor(if (selectedTab == binding.tabGym) whiteColor else mutedColor)

            binding.tabHome.background = if (selectedTab == binding.tabHome) selectedBg else normalBg
            binding.tabHome.setTextColor(if (selectedTab == binding.tabHome) whiteColor else mutedColor)

            binding.tabMyPlan.background = if (selectedTab == binding.tabMyPlan) selectedBg else normalBg
            binding.tabMyPlan.setTextColor(if (selectedTab == binding.tabMyPlan) whiteColor else mutedColor)

            when (selectedTab) {
                binding.tabGym -> displayWorkouts(gymWorkouts)
                binding.tabHome -> displayWorkouts(homeWorkouts)
                binding.tabMyPlan -> displayWorkouts(myPlanWorkouts)
            }
        }

        binding.tabGym.setOnClickListener { updateTabs(it) }
        binding.tabHome.setOnClickListener { updateTabs(it) }
        binding.tabMyPlan.setOnClickListener { updateTabs(it) }
    }

    private fun displayWorkouts(categories: List<WorkoutCategory>) {
        binding.rvWorkouts.adapter = WorkoutCategoryAdapter(categories) { category ->
            val intent = Intent(requireContext(), ExerciseDetailActivity::class.java).apply {
                putExtra("CATEGORY_NAME", category.title)
            }
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
