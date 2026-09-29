package com.example.fitnest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnest.databinding.ItemWorkoutCategoryBinding
import com.example.fitnest.model.WorkoutCategory

class WorkoutCategoryAdapter(
    private val categories: List<WorkoutCategory>,
    private val onItemClick: (WorkoutCategory) -> Unit
) : RecyclerView.Adapter<WorkoutCategoryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemWorkoutCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWorkoutCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categories[position]
        holder.binding.tvCategoryTitle.text = item.title
        holder.binding.tvCategorySubtitle.text = item.subtitle
        holder.binding.ivCategoryIcon.setImageResource(item.iconRes)

        holder.binding.root.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = categories.size
}
