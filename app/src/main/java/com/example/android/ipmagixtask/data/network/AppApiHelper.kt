package com.example.android.ipmagixtask.data.network

import com.example.android.ipmagixtask.data.network.model.StudentsResult
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
const val BASE_URL="http://demo6589417.mockable.io/ipmagix.studentsapi"
class AppApiHelper:ApiHelper {
    override fun getAllStudents(): Observable<StudentsResult> {
        return Rx2AndroidNetworking.get(BASE_URL)
            .build()
            .getObjectObservable(StudentsResult::class.java)
    }
}