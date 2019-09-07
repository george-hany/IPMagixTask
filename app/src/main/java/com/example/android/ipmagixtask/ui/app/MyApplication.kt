package com.example.android.ipmagixtask.ui.app

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.example.android.ipmagixtask.di.AppComponent
import com.example.android.ipmagixtask.di.DaggerAppComponent
import com.example.android.ipmagixtask.ui.studentsactivity.StudentsActivity

class MyApplication:Application() {

    companion object {
        lateinit var appComponent: AppComponent
        fun injectStudentsActivity(studentsActivity: StudentsActivity){
            appComponent.injectStudentsActivity(studentsActivity)
        }
    }
        override fun onCreate() {
            super.onCreate()
            initDataComponent()
            //initialize AndroidNetworking
            AndroidNetworking.initialize(this)
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BASIC)
        }

        private fun initDataComponent() {
            //initialize the appComponent
            appComponent = DaggerAppComponent.builder()
                .build()
        }




}