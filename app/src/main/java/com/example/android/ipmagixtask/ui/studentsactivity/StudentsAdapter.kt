package com.example.android.ipmagixtask.ui.studentsactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.ipmagixtask.R
import com.example.android.ipmagixtask.data.network.model.Student
import com.example.android.ipmagixtask.databinding.StudentItemBinding

class StudentsAdapter(var students:List<Student>):RecyclerView.Adapter<StudentsAdapter.StudentsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: StudentItemBinding = DataBindingUtil.inflate(inflater, R.layout.student_item, parent, false)
        val h = StudentsHolder(binding)
        return h
    }

    override fun getItemCount(): Int =students.size

    override fun onBindViewHolder(holder: StudentsHolder, index: Int) {
        holder.Bind(students[index])

    }

    class StudentsHolder(var view:StudentItemBinding):RecyclerView.ViewHolder(view.root) {
        fun Bind(student:Student){
            //bind view to student object
            view.student=student
        }
    }
}