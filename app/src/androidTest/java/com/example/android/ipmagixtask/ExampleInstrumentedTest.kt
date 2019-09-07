package com.example.android.ipmagixtask

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.example.android.ipmagixtask.data.network.ApiHelper
import com.example.android.ipmagixtask.data.network.AppApiHelper
import com.example.android.ipmagixtask.ui.studentsactivity.StudentsViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    companion object {
        @JvmStatic
        lateinit var studentsViewModel: StudentsViewModel
        fun inits(){
            studentsViewModel=StudentsViewModel(AppApiHelper())
        }
    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.android.ipmagixtask", appContext.packageName)
    }

    @Test
    fun dd(){
        studentsViewModel=StudentsViewModel(AppApiHelper())

        studentsViewModel.getAllStudents()
        assertNotNull(studentsViewModel.students.value)
    }
}
