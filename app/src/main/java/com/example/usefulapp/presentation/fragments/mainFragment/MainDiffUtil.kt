package com.example.usefulapp.presentation.fragments.mainFragment

import androidx.recyclerview.widget.DiffUtil
import com.example.usefulapp.domain.mainAndCourse.model.CourseModel

class MainDiffUtil: DiffUtil.ItemCallback<CourseModel>() {
    override fun areItemsTheSame(oldItem: CourseModel, newItem: CourseModel) = oldItem.nameOfCourse == newItem.nameOfCourse

    override fun areContentsTheSame(oldItem: CourseModel, newItem: CourseModel) = oldItem == newItem
}