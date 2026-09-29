package com.example.fitnest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnest.R
import com.example.fitnest.databinding.ItemDailyMealBinding
import com.example.fitnest.model.DailyMeal

class DailyMealAdapter(
    private val meals: MutableList<DailyMeal>,
    private val onMealClick: (DailyMeal) -> Unit
) : RecyclerView.Adapter<DailyMealAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDailyMealBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDailyMealBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = meals[position]
        holder.binding.tvMealType.text = meal.mealType
        holder.binding.tvMealDescription.text = meal.description
        holder.binding.tvMealCalories.text = meal.calories

        if (meal.isCompleted) {
            holder.binding.ivMealStatus.setImageResource(R.drawable.ic_check_circle)
        } else {
            holder.binding.ivMealStatus.setImageResource(R.drawable.ic_radio_unchecked)
        }

        holder.binding.root.setOnClickListener {
            meal.isCompleted = !meal.isCompleted
            notifyItemChanged(position)
            onMealClick(meal)
        }
    }

    override fun getItemCount(): Int = meals.size
}
