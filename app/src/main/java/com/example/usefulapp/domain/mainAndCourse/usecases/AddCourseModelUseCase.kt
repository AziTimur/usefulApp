package com.example.usefulapp.domain.mainAndCourse.usecases

import android.content.Context
import androidx.navigation.NavController
import com.example.usefulapp.domain.mainAndCourse.repository.AddCourseRepository
import com.example.usefulapp.domain.mainAndCourse.model.CourseModel
import javax.inject.Inject

class AddCourseModelUseCase @Inject constructor(private val repositoryAdd: AddCourseRepository) {

    fun addCourseModel(
        courseModel: CourseModel,
        context: Context,
        findNavController: NavController
    ) = repositoryAdd.addCourseModel(courseModel, context, findNavController)

}