package com.example.fitnest.model

data class WorkoutCategory(
    val id: String,
    val title: String,
    val subtitle: String,
    val iconRes: Int
)

data class DailyMeal(
    val id: String,
    val mealType: String,
    val description: String,
    val calories: String,
    var isCompleted: Boolean,
    val iconRes: Int
)

data class LeaderboardUser(
    val rank: Int,
    val name: String,
    val xp: String,
    val isCurrentUser: Boolean = false
)

data class NotificationModel(
    val id: String,
    val title: String,
    val description: String,
    val time: String,
    val iconRes: Int
)
