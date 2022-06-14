package com.example.usefulapp.presentation.fragments.secondRegistration

import androidx.lifecycle.ViewModel
import com.example.usefulapp.data.ImgRepositoryImpl
import com.example.usefulapp.domain.personals.models.ModelImg
import com.example.usefulapp.domain.personals.useCases.AddImgUseCase
import com.example.usefulapp.domain.personals.useCases.DeleteImgUseCase
import com.example.usefulapp.domain.personals.useCases.GetImgUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondRegisterViewModel @Inject constructor(private val repository: ImgRepositoryImpl) :
    ViewModel() {

    private val addImgUseCase = AddImgUseCase(repository)

    private val getImgUseCase = GetImgUseCase(repository)

    private val deleteImgUseCase = DeleteImgUseCase(repository)

    val imgList = getImgUseCase.getImg()

    fun addImgItem(img: ModelImg) {
        addImgUseCase.addImg(img)
    }

    fun deleteImg(img: ModelImg) {
        deleteImgUseCase.deleteImg(img)
    }
}