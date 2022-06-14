package com.example.usefulapp.presentation.fragments.mainFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usefulapp.domain.Response
import com.example.usefulapp.domain.mainAndCourse.model.CourseModel
import com.example.usefulapp.domain.mainAndCourse.usecases.GetListCourseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(private val getListCourseUseCase: GetListCourseUseCase) :
    ViewModel() {

    private val _getCourse = MutableStateFlow<Response<List<CourseModel>>>(Response.Loading())
    val getCourse = _getCourse.asStateFlow()

    init {
        getCourseList()
    }

    private fun getCourseList() {
        viewModelScope.launch {
            getListCourseUseCase.getListCourse().collect {
                _getCourse.value = it
            }
        }
    }
}