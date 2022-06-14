package com.example.usefulapp.domain.mainAndCourse.usecases

import com.example.usefulapp.domain.mainAndCourse.repository.MainRepository
import javax.inject.Inject

class GetListCourseUseCase @Inject constructor(private val mainRepository: MainRepository) {

    fun getListCourse() = mainRepository.getListModel()

}