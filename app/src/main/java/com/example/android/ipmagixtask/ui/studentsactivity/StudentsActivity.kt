package com.example.android.ipmagixtask.ui.studentsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.android.ipmagixtask.R
import com.example.android.ipmagixtask.data.network.model.Student
import com.example.android.ipmagixtask.databinding.ActivityMainBinding
import com.example.android.ipmagixtask.ui.app.MyApplication
import com.example.android.ipmagixtask.ui.studentsactivity.adapter.StudentsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class StudentsActivity : AppCompatActivity() {

    @Inject
    lateinit var studentsViewModel: StudentsViewModel

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //inject the activity to get instance of viewModel
        MyApplication.injectStudentsActivity(this)
         binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.vm=studentsViewModel
        //call the api to get students
        val studentsList=ArrayList<Student>()
        val adapter=StudentsAdapter(studentsList)
        binding.studentsRecycle.adapter=adapter
        studentsViewModel.getAllStudents()
        studentsViewModel.students.observe(this, Observer {
            progressBar.visibility = GONE
            studentsList.clear()
            studentsList.addAll(it)
            adapter.notifyDataSetChanged()
        })

    }
}
