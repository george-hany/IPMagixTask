package com.example.android.ipmagixtask.data.network

import com.example.android.ipmagixtask.data.network.model.StudentsResult
import io.reactivex.Single

interface ApiHelper {
    fun getAllStudents():Single<StudentsResult>
}