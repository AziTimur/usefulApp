package com.example.usefulapp.domain.personals.models


data class ModelImg(
    val photo : String,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}