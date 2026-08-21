package com.example.fitnest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StudentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_student_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val students = listOf(
            Student(1, "Chirag", "9876543210", "Rajkot",
                "Chirag is focusing on building muscle and follows a strength training routine."),
            Student(2, "Rahul", "9876543211", "Ahmedabad",
                "Rahul's fitness goal is weight loss and improving cardiovascular endurance.",),
            Student(3, "Riya", "9876543212", "Surat",
                "Riya focuses on yoga, flexibility, and maintaining an active lifestyle."),
            Student(4, "Amit", "9876543213", "Jamnagar",
                "Amit is training to improve endurance and stamina through running and full-body workouts."),
            Student(5, "Priya", "9876543214", "Vadodara",
                "Priya follows a fitness routine focused on strength training, core exercises, and healthy nutrition."),
            Student(6, "Karan", "9876543215", "Bhavnagar",
                "Karan is working on gaining muscle mass and follows a structured weight training routine."),
            Student(7, "Neha", "9876543216", "Gandhinagar",
                "Neha focuses on maintaining overall fitness with a combination of cardio, yoga, and light strength training."),
            Student(8, "Arjun", "9876543217", "Junagadh",
                "Arjun is preparing for better athletic performance by improving strength, speed, and endurance."),
            Student(9, "Meera", "9876543218", "Rajkot",
                "Meera focuses on flexibility and core strength through regular yoga and Pilates workouts."),
            Student(10, "Vivek", "9876543219", "Morbi",
                "Vivek follows a balanced fitness routine with gym workouts, cardio sessions, and a protein-rich diet.")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StudentAdapter(students)
    }
}