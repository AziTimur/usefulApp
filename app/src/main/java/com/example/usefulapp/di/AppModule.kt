package com.example.usefulapp.di

import com.example.usefulapp.data.AddCourseRepositoryImpl
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.example.usefulapp.data.MainRepositoryImpl
import com.example.usefulapp.domain.mainAndCourse.repository.AddCourseRepository
import com.example.usefulapp.domain.mainAndCourse.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    //Провайд фаерстора
    @Singleton
    @Provides
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()

    //Провайд квери запроса для провайда репозитории
    @Singleton
    @Provides
    fun provideCourseQuery(courseDB: CollectionReference) = courseDB.orderBy("nameOfCourse")

    //Провайд дата бейса и получение колекции
    @Singleton
    @Provides
    fun provideCourseDB(db: FirebaseFirestore) = db.collection("course")

    //Провайд репозитория
    @Provides
    @Singleton
    fun provideMainRepository(courseQuery: Query): MainRepository = MainRepositoryImpl(courseQuery)


    @Provides
    @Singleton
    fun provideCourseRepository() : AddCourseRepository = AddCourseRepositoryImpl()
}