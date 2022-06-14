package com.example.usefulapp.presentation.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.usefulapp.R
import com.example.usefulapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding:ActivityMainBinding by viewBinding()
    private lateinit var navController: NavController
    private val fragments = arrayListOf(
        R.id.mainFragment,
        R.id.personalFragment,
        R.id.searchFragment,
        R.id.educationFragment

    )

    //проверка на то что есть такой юзер или нет
    override fun onStart() {
        super.onStart()
        val auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            navController.navigate(R.id.mainFragment)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavController()
    }



    //инициализация навКонтроллера
    private fun initNavController() {
        val navHostController = supportFragmentManager.findFragmentById(R.id.navHostFragment)
        navController = navHostController!!.findNavController()
        binding.bottomNav.setupWithNavController(navController)


        //скрыть bottomNavigation
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (fragments.contains(destination.id)) {
                binding.bottomNav.visibility = View.VISIBLE
            } else binding.bottomNav.visibility = View.GONE
        }
    }

}