package com.example.usefulapp.data

import com.google.firebase.firestore.Query
import com.example.usefulapp.domain.Response.*
import com.example.usefulapp.domain.mainAndCourse.model.CourseModel
import com.example.usefulapp.domain.mainAndCourse.repository.MainRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val courseQuery: Query
) : MainRepository {

    //Стягивает данные
    override fun getListModel() = callbackFlow {
        val snapshotListener = courseQuery.addSnapshotListener { snapshot, e ->
            val response = if (snapshot != null) {
                val course = snapshot.toObjects(CourseModel::class.java)
                Success(course)
            } else {
                Error(e?.localizedMessage ?: "Error")
            }
            trySend(response).isSuccess
        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}