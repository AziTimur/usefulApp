package com.example.usefulapp.domain.personals.repository

import androidx.lifecycle.LiveData
import com.example.usefulapp.domain.personals.models.ModelImg

interface ImgRepository {
    fun addImg(img: ModelImg)
    fun getImg(): LiveData<List<ModelImg>>
    fun deleteImg(img: ModelImg)
}