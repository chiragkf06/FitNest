package com.example.fitnest.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnest.R
import com.example.fitnest.databinding.FragmentDietBinding
import com.example.fitnest.model.DailyMeal
import com.example.fitnest.ui.activities.MealScannerActivity
import com.example.fitnest.ui.activities.NotificationsActivity
import com.example.fitnest.ui.adapters.DailyMealAdapter

class DietFragment : Fragment() {

    private var _binding: FragmentDietBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDietBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMealsList()

        binding.btnDietNotifications.setOnClickListener {
            val intent = Intent(requireContext(), NotificationsActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogMeal.setOnClickListener {
            val intent = Intent(requireContext(), MealScannerActivity::class.java)
            startActivity(intent)
        }

        binding.btnPrevDay.setOnClickListener {
            binding.tvCurrentDate.text = "Yesterday, 26 May"
            Toast.makeText(requireContext(), "Showing meals for 26 May", Toast.LENGTH_SHORT).show()
        }

        binding.btnNextDay.setOnClickListener {
            binding.tvCurrentDate.text = "Tomorrow, 28 May"
            Toast.makeText(requireContext(), "Showing planned meals for 28 May", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupMealsList() {
        val meals = mutableListOf(
            DailyMeal("1", "Breakfast", "Oatmeal with fruits", "350 kcal", true, R.drawable.ic_diet),
            DailyMeal("2", "Lunch", "Grilled Chicken, Brown Rice, Salad", "620 kcal", true, R.drawable.ic_diet),
            DailyMeal("3", "Snack", "Greek Yogurt with Nuts", "200 kcal", false, R.drawable.ic_diet),
            DailyMeal("4", "Dinner", "Paneer Curry, Roti, Salad", "550 kcal (Planned)", false, R.drawable.ic_diet)
        )

        binding.rvMeals.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMeals.adapter = DailyMealAdapter(meals) { meal ->
            val status = if (meal.isCompleted) "Completed" else "Marked pending"
            Toast.makeText(requireContext(), "${meal.mealType} $status", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
