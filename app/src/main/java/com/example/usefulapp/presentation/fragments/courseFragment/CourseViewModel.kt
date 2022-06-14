package com.example.usefulapp.presentation.fragments.courseFragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.usefulapp.domain.mainAndCourse.model.CourseModel
import com.example.usefulapp.domain.mainAndCourse.usecases.AddCourseModelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(private val addCourseModelUseCase: AddCourseModelUseCase) :
    ViewModel() {

    fun addCourseModel(courseModel: CourseModel, context : Context, findNavController: NavController) {
        viewModelScope.launch {
            addCourseModelUseCase.addCourseModel(courseModel, context, findNavController)
        }
    }

}