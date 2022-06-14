package com.example.usefulapp.presentation.fragments.personalFragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.usefulapp.R
import com.example.usefulapp.databinding.FragmentEditPersonalBinding

const val CONTACTS = "CONTACTS"
const val CITY = "CITY"
const val PROFESSION = "PROFESSION"

class EditPersonalFragment : Fragment(R.layout.fragment_edit_personal) {
    private val binding: FragmentEditPersonalBinding by viewBinding()
    lateinit var preferences: SharedPreferences


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveData.setOnClickListener {
            val SHARED_EXPERIENCE = "ss"
            val SHAREDetCareerDescription = "aa"
            val SHARED_NAME = "dd"
            preferences.edit().putString(SHARED_EXPERIENCE, binding.etAddExperience.text.toString())
                .putString(SHAREDetCareerDescription, binding.etAddSpeciality.text.toString())
                .putString(SHARED_NAME, binding.etName.text.toString())
                .putString(CITY, binding.etAddCity.text.toString())
                .putString(CONTACTS, binding.etAddContact.text.toString())
                .putString(PROFESSION, binding.etAddEducation.text.toString())
                .apply()
            findNavController().navigate(R.id.action_editPersonalFragment_to_personalFragment)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val APP_PREFERENCES = "ff"
        preferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

    }


}
