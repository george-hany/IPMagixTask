package com.example.android.ipmagixtask

import android.content.Context
import com.example.android.ipmagixtask.data.network.ApiHelper
import com.example.android.ipmagixtask.data.network.AppApiHelper
import com.example.android.ipmagixtask.data.network.model.Student
import com.example.android.ipmagixtask.ui.studentsactivity.StudentsViewModel
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import java.util.*

class StudentActivityViewModelTest {
    lateinit var apiHelper: ApiHelper
    lateinit var viewModel: StudentsViewModel


    @Mock
    val realData = listOf<Student>(
        Student("123", "Mohamed"),
        Student("435", "Foad"),
        Student("827", "Sara"),
        Student("540", "Gamil"),
        Student("871", "Sayed"),
        Student("396", "Mohamed"),
        Student("287", "Ahmed"),
        Student("109", "Mina"),
        Student("254", "Lobna"),
        Student("892", "Nehal"),
        Student("784", "Omnia"),
        Student("452", "Yosry"),
        Student("671", "Magdy")
    )

    @Mock
    val expectedSortedAscending = listOf<Student>(
        Student("287", "Ahmed"),
        Student("435", "Foad"),
        Student("540", "Gamil"),
        Student("254", "Lobna"),
        Student("671", "Magdy"),
        Student("109", "Mina"),
        Student("123", "Mohamed"),
        Student("396", "Mohamed"),
        Student("892", "Nehal"),
        Student("784", "Omnia"),
        Student("827", "Sara"),
        Student("871", "Sayed"),
        Student("452", "Yosry")
    )

    @Mock
    val expectedSortedDescending = listOf<Student>(
        Student("452", "Yosry"),
        Student("871", "Sayed"),
        Student("827", "Sara"),
        Student("784", "Omnia"),
        Student("892", "Nehal"),
        Student("123", "Mohamed"),
        Student("396", "Mohamed"),
        Student("109", "Mina"),
        Student("671", "Magdy"),
        Student("254", "Lobna"),
        Student("540", "Gamil"),
        Student("435", "Foad"),
        Student("287", "Ahmed")
    )

    @Before
    fun befor() {
        apiHelper = AppApiHelper()
        viewModel = StudentsViewModel(apiHelper)
        viewModel.studentsResponse = realData
    }


    @Test
    fun testWhenSortAscendingSuccess() {
        viewModel.sortAscending()
        var i = 0
        for (s in viewModel.studentsResponse!!) {
            assertTrue(
                expectedSortedAscending[i].studentId ==
                        s.studentId
            )
            i++
        }
    }


    @Test
    fun testWhenSortAscendingFailed() {
        viewModel.sortAscending()
        var i = 0
        for (s in viewModel.studentsResponse!!) {
            assertFalse(
                expectedSortedAscending[i].studentId != s.studentId
            )
            i++
        }
    }


    @Test
    fun testWhenSortDescendingSuccess() {
        viewModel.sortDescending()
        var i = 0
        for (s in viewModel.studentsResponse!!) {
            assertTrue(
                expectedSortedDescending[i].studentId ==
                        s.studentId
            )
            i++
        }
    }

    @Test
    fun testWhenSortDescendingFailed() {
        viewModel.sortDescending()
        var i = 0
        for (s in viewModel.studentsResponse!!) {
            assertFalse(
                expectedSortedDescending[i].studentId != s.studentId
            )
            i++
        }
    }
}