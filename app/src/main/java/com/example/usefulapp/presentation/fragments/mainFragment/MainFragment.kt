package com.example.usefulapp.presentation.fragments.mainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.usefulapp.R
import com.example.usefulapp.databinding.FragmentMainBinding
import com.example.usefulapp.domain.mainAndCourse.model.CourseModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()
    private var list: ArrayList<CourseModel> = arrayListOf()
    private val adapter: MainAdapter by lazy {
        MainAdapter()
    }
    private val viewModel: MainFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
        setupListeners()
    }

    private fun setupListeners() {
        adapter.onItemClick = {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToDetailsFragment(
                    it
                )
            )
        }
        adapter.onItemClick2 = {
            Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()

        }
    }

    private fun setupUI() {
        binding.recyclerMain.apply {
            adapter = this@MainFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.getCourse.collectLatest {
                adapter.submitList(it.data)
                binding.progressBar.visibility = View.GONE
            }
        }
    }

}

