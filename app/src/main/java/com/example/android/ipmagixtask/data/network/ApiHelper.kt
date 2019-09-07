package com.example.android.ipmagixtask.data.network

import com.example.android.ipmagixtask.data.network.model.StudentsResult
import io.reactivex.Observable

interface ApiHelper {
    fun getAllStudents():Observable<StudentsResult>
}