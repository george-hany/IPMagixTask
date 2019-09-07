package com.example.android.ipmagixtask.di

import com.example.android.ipmagixtask.data.network.ApiHelper
import com.example.android.ipmagixtask.data.network.AppApiHelper
import com.example.android.ipmagixtask.ui.studentsactivity.StudentsViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaggerHelper {

    @Provides
    @Singleton
    fun getApiHelper(): ApiHelper {
        return AppApiHelper()
    }

    @Provides
    @Singleton
    fun getStudentsViewModel(apiHelper: ApiHelper) =
        StudentsViewModel(apiHelper)
}