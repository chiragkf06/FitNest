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
import com.example.fitnest.databinding.FragmentLeaderboardBinding
import com.example.fitnest.model.LeaderboardUser
import com.example.fitnest.ui.activities.NotificationsActivity
import com.example.fitnest.ui.adapters.LeaderboardAdapter

class LeaderboardFragment : Fragment() {

    private var _binding: FragmentLeaderboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaderboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTabs()
        setupRankingsList()

        binding.btnLeaderboardNotifications.setOnClickListener {
            val intent = Intent(requireContext(), NotificationsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupTabs() {
        val selectedBg = ContextCompat.getDrawable(requireContext(), R.drawable.bg_pill_green)
        val normalBg = ContextCompat.getDrawable(requireContext(), R.drawable.bg_pill_gray)
        val whiteColor = ContextCompat.getColor(requireContext(), R.color.white)
        val mutedColor = ContextCompat.getColor(requireContext(), R.color.text_secondary)

        binding.tabGlobal.setOnClickListener {
            binding.tabGlobal.background = selectedBg
            binding.tabGlobal.setTextColor(whiteColor)
            binding.tabFriends.background = normalBg
            binding.tabFriends.setTextColor(mutedColor)
        }

        binding.tabFriends.setOnClickListener {
            binding.tabFriends.background = selectedBg
            binding.tabFriends.setTextColor(whiteColor)
            binding.tabGlobal.background = normalBg
            binding.tabGlobal.setTextColor(mutedColor)
        }
    }

    private fun setupRankingsList() {
        val users = listOf(
            LeaderboardUser(4, "Neha", "1100 XP"),
            LeaderboardUser(5, "Arjun", "1050 XP"),
            LeaderboardUser(12, "You (Chirag)", "980 XP", isCurrentUser = true),
            LeaderboardUser(13, "Rohan", "920 XP"),
            LeaderboardUser(14, "Karan", "890 XP")
        )

        binding.rvLeaderboard.layoutManager = LinearLayoutManager(requireContext())
        binding.rvLeaderboard.adapter = LeaderboardAdapter(users)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
