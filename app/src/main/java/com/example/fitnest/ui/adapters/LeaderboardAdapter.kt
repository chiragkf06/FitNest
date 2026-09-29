package com.example.fitnest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnest.R
import com.example.fitnest.databinding.ItemLeaderboardBinding
import com.example.fitnest.model.LeaderboardUser

class LeaderboardAdapter(
    private val users: List<LeaderboardUser>
) : RecyclerView.Adapter<LeaderboardAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemLeaderboardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLeaderboardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        val context = holder.binding.root.context

        holder.binding.tvRankNumber.text = user.rank.toString()
        holder.binding.tvLeaderboardName.text = user.name
        holder.binding.tvLeaderboardXP.text = user.xp
        holder.binding.tvAvatarInitial.text = user.name.take(1)

        if (user.isCurrentUser) {
            holder.binding.layoutLeaderboardItem.background =
                ContextCompat.getDrawable(context, R.drawable.bg_user_highlight)
            holder.binding.tvLeaderboardName.setTextColor(
                ContextCompat.getColor(context, R.color.primary)
            )
            holder.binding.tvRankNumber.setTextColor(
                ContextCompat.getColor(context, R.color.primary)
            )
        } else {
            holder.binding.layoutLeaderboardItem.background =
                ContextCompat.getDrawable(context, R.drawable.bg_pill_white)
            holder.binding.tvLeaderboardName.setTextColor(
                ContextCompat.getColor(context, R.color.text_main)
            )
            holder.binding.tvRankNumber.setTextColor(
                ContextCompat.getColor(context, R.color.text_secondary)
            )
        }
    }

    override fun getItemCount(): Int = users.size
}
