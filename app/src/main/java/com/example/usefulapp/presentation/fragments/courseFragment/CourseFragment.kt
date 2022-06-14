package com.example.usefulapp.presentation.fragments.courseFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.usefulapp.R
import com.example.usefulapp.databinding.FragmentCourseBinding
import com.example.usefulapp.domain.mainAndCourse.model.CourseModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseFragment : Fragment(R.layout.fragment_course) {

    private val binding: FragmentCourseBinding by viewBinding()
    private lateinit var course : CourseModel
    private val viewModel : CourseViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCreate.setOnClickListener {
            initDb()
        }
    }

    private fun initDb() {
        Log.e("TAG", "initDb: ", )
        course = CourseModel(
            binding.etNameOfCourse.text.toString(),
            binding.etNameOfAuthor.text.toString(),
            binding.etDescription.text.toString(),
            binding.etProfession.text.toString(),
            binding.etInformationFree.text.toString(),
            binding.etInformation.text.toString(),
            binding.etImage.text.toString(),
            binding.etDescription.text.toString(),
            binding.etYoutube.text.toString(),
            binding.etHomework.text.toString(),
            binding.etTest.text.toString(),
            binding.etPrice.text.toString(),
        )
        viewModel.addCourseModel(course, requireContext(), findNavController())

    }

}