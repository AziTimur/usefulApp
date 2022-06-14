package com.example.usefulapp.domain.personals.useCases

import com.example.usefulapp.domain.personals.repository.ImgRepository
import javax.inject.Inject


class GetImgUseCase @Inject constructor(private val repository: ImgRepository) {

    fun getImg()=repository.getImg()

}