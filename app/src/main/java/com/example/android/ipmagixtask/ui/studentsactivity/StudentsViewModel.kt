package com.example.android.ipmagixtask.ui.studentsactivity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.ipmagixtask.data.network.ApiHelper
import com.example.android.ipmagixtask.data.network.model.Student
import com.example.android.ipmagixtask.data.network.model.StudentsResult
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class StudentsViewModel constructor(var apiHelper: ApiHelper):ViewModel() {
    val students=MutableLiveData<ArrayList<Student>>()

    fun getAllStudents(){
        //get the observable from apihelper
        val observable=apiHelper.getAllStudents()
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<StudentsResult>{
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: StudentsResult) {
                    students.value=t.data
                }

                override fun onError(e: Throwable) {
                }
            })
    }
}