package com.example.fitnest.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnest.R
import com.example.fitnest.databinding.FragmentWorkoutBinding
import com.example.fitnest.model.WorkoutCategory
import com.example.fitnest.ui.activities.ExerciseDetailActivity
import com.example.fitnest.ui.adapters.WorkoutCategoryAdapter

class WorkoutFragment : Fragment() {

    private var _binding: FragmentWorkoutBinding? = null
    private val binding get() = _binding!!

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

        setupTabs()
        setupWorkoutList()

        binding.btnRefreshWorkouts.setOnClickListener {
            Toast.makeText(requireContext(), "Workout plan updated", Toast.LENGTH_SHORT).show()
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
        }

        binding.tabGym.setOnClickListener { updateTabs(it) }
        binding.tabHome.setOnClickListener { updateTabs(it) }
        binding.tabMyPlan.setOnClickListener { updateTabs(it) }
    }

    private fun setupWorkoutList() {
        val categories = listOf(
            WorkoutCategory("1", "Chest", "6 Exercises", R.drawable.ic_workout),
            WorkoutCategory("2", "Back", "5 Exercises", R.drawable.ic_workout),
            WorkoutCategory("3", "Legs", "6 Exercises", R.drawable.ic_workout),
            WorkoutCategory("4", "Shoulders", "5 Exercises", R.drawable.ic_workout),
            WorkoutCategory("5", "Arms", "6 Exercises", R.drawable.ic_workout),
            WorkoutCategory("6", "Abs", "4 Exercises", R.drawable.ic_workout),
            WorkoutCategory("7", "Cardio", "30 mins", R.drawable.ic_directions_walk)
        )

        binding.rvWorkouts.layoutManager = LinearLayoutManager(requireContext())
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
