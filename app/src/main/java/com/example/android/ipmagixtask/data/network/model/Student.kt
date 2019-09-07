package com.example.android.ipmagixtask.data.network.model

class Student  (
    val studentId :String,
    val studentName:String
):Comparable<Student>{
    override fun compareTo(other: Student) = compareValuesBy(this,other,{it.studentName})

}

class StudentsResult{
    lateinit var data:ArrayList<Student>
}