package com.example.android.ipmagixtask.di

import com.example.android.ipmagixtask.ui.studentsactivity.StudentsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(DaggerHelper::class))
interface AppComponent {

fun injectStudentsActivity(studentsActivity: StudentsActivity)
}