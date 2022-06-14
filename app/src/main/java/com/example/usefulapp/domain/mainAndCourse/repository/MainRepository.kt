package com.example.usefulapp.domain.mainAndCourse.repository

import com.example.usefulapp.domain.Response
import com.example.usefulapp.domain.mainAndCourse.model.CourseModel
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getListModel() : Flow<Response<List<CourseModel>>>
}