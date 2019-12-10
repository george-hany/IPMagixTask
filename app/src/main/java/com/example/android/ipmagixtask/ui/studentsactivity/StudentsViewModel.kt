package com.example.android.ipmagixtask.ui.studentsactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.ipmagixtask.data.network.ApiHelper
import com.example.android.ipmagixtask.data.network.model.Student
import com.example.android.ipmagixtask.data.network.model.StudentsResult
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class StudentsViewModel constructor(var apiHelper: ApiHelper):ViewModel() {
    val students=MutableLiveData<List<Student>>()
     var studentsResponse:ArrayList<Student>?=null

    fun getAllStudents(){
        //get the observable from apihelper
        val observable=apiHelper.getAllStudents()
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :SingleObserver<StudentsResult>{

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }

                override fun onSuccess(t: StudentsResult) {
                    studentsResponse=t.data
                    sortAscending()                }
            })
    }
    fun sortAscending(){
        studentsResponse?.let{ it ->
            val list= it.sortedWith(compareBy { it.studentName })
            students.value=list
        }
    }
    fun sortDescending(){
        studentsResponse?.let{it->
            val list= it.sortedWith(compareByDescending { it.studentName })
            students.value=list
        }
    }
}