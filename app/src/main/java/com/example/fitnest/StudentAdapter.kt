package com.example.fitnest

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.jvm.java

class StudentAdapter(
    private val students: List<Student>
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val idText: TextView = itemView.findViewById(R.id.idText)
        val nameText: TextView = itemView.findViewById(R.id.nameText)
        val mobileText: TextView = itemView.findViewById(R.id.mobileText)
        val cityText: TextView = itemView.findViewById(R.id.cityText)
        val descText : TextView = itemView.findViewById(R.id.descText)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_card, parent, false)

        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: StudentViewHolder,
        position: Int
    ) {

        val student = students[position]

        //Show on ui
        holder.idText.text = "ID: ${student.id}"
        holder.nameText.text = "Name: ${student.name}"
        holder.mobileText.text = "Mobile: ${student.mobile}"
        holder.cityText.text = "City: ${student.city}"

        holder.itemView.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                StudentDetailActivity::class.java
            )

            intent.putExtra("STUDENT_NAME", student.name)
            intent.putExtra("STUDENT_DESCRIPTION", student.description)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return students.size
    }
}