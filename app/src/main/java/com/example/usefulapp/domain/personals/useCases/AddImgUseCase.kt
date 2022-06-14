package com.example.usefulapp.domain.personals.useCases

import com.example.usefulapp.domain.personals.repository.ImgRepository
import com.example.usefulapp.domain.personals.models.ModelImg
import javax.inject.Inject


class AddImgUseCase @Inject constructor(private val repository: ImgRepository) {
    fun addImg(img: ModelImg) {
        repository.addImg(img)
    }
}