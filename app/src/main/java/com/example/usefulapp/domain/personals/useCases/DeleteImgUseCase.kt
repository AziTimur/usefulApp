package com.example.usefulapp.domain.personals.useCases

import com.example.usefulapp.domain.personals.repository.ImgRepository
import com.example.usefulapp.domain.personals.models.ModelImg
import javax.inject.Inject

class DeleteImgUseCase @Inject constructor(private val repository: ImgRepository) {
    fun deleteImg(img: ModelImg) {
        repository.deleteImg(img)
    }
}