package com.example.usefulapp.domain.mainAndCourse.repository

import android.content.Context
import androidx.navigation.NavController
import com.example.usefulapp.domain.mainAndCourse.model.CourseModel


interface AddCourseRepository {

    fun addCourseModel(courseModel: CourseModel, context: Context, findNavController: NavController)
}