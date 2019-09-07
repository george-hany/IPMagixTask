package com.example.android.ipmagixtask.ui.studentsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import com.example.android.ipmagixtask.R
import com.example.android.ipmagixtask.data.network.model.Student
import com.example.android.ipmagixtask.ui.app.MyApplication
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class StudentsActivity : AppCompatActivity() {

    @Inject
    lateinit var studentsViewModel: StudentsViewModel
    var sortDesc=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //inject the activity to get instance of viewModel
        MyApplication.injectStudentsActivity(this)
        //call the api to get students
        studentsViewModel.getAllStudents()
        studentsViewModel.students.observe(this, Observer {
            //to check sort status if the data is changed
            if (!sortDesc){
                //sort by user name
                val list=it.sortedWith(compareBy({it.studentName}))
                students_recycle.adapter=StudentsAdapter(list)
                progressBar.visibility=GONE
            }
            else{
                val list=it.sortedWith(compareByDescending ({it.studentName}))
                students_recycle.adapter=StudentsAdapter(list)
                progressBar.visibility=GONE

            }
        })
        sort_desc_btn.setOnClickListener {
            //sort the data descending
            sortDesc=true
            progressBar.visibility=VISIBLE
            val list=studentsViewModel.students.value!!.sortedWith(compareByDescending ({it.studentName}))
            students_recycle.adapter=StudentsAdapter(list)
            progressBar.visibility=GONE

        }
        sort_Asc_btn.setOnClickListener {
            //sort the data ascending
            sortDesc=false
            progressBar.visibility=VISIBLE
            val list=studentsViewModel.students.value!!.sortedWith(compareBy({it.studentName}))
            students_recycle.adapter=StudentsAdapter(list)
            progressBar.visibility=GONE

        }
    }
}
