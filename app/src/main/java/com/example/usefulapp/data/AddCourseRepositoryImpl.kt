package com.example.usefulapp.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.usefulapp.R
import com.google.firebase.firestore.FirebaseFirestore
import com.example.usefulapp.domain.mainAndCourse.repository.AddCourseRepository
import com.example.usefulapp.domain.mainAndCourse.model.CourseModel
import javax.inject.Inject

class AddCourseRepositoryImpl @Inject constructor() : AddCourseRepository {

    override fun addCourseModel(courseModel: CourseModel, context: Context, findNavController: NavController) {
        val db = FirebaseFirestore.getInstance()
        db.collection("course")
            .add(courseModel)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    findNavController.navigate(R.id.action_courseFragment_to_personalFragment)
                    Toast.makeText(context, "success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "failure", Toast.LENGTH_SHORT).show()
                }
            }

    }


}