package com.denisardent.main.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.denisardent.common.AppException
import com.denisardent.common.ErrorStatusResult
import com.denisardent.common.SuccessStatusResult
import com.denisardent.common.entities.FoodCategory
import com.denisardent.main.R

import com.denisardent.main.databinding.FragmentMainBinding
import com.denisardent.main.domain.CategoriesRepository
import com.denisardent.main.domain.NavigateToCategories
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment: Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var navigateToCategories: NavigateToCategories

    @Inject
    lateinit var categoriesRepository: CategoriesRepository
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding.cardView3.setOnClickListener {
            navigateToCategories.navigateToCategories(findNavController())
        }
        lifecycleScope.launch {
            val result = categoriesRepository.getCategoriesList()
            if (result is SuccessStatusResult){
                updateUI(result.data)
            } else if (result is ErrorStatusResult){
                throw result.exception
            }
        }
    }

    private fun updateUI(data: List<FoodCategory>){
        binding.categoryName1.text = data[0].name
        binding.categoryName2.text = data[1].name
        binding.categoryName3.text = data[2].name
        binding.categoryName4.text = data[3].name

        Glide
            .with(this)
            .load(data[0].imageUrl)
            .into(binding.categoryIv1)

        Glide
            .with(this)
            .load(data[1].imageUrl)
            .into(binding.categoryIv2)

        Glide
            .with(this)
            .load(data[2].imageUrl)
            .into(binding.categoryIv3)

        Glide
            .with(this)
            .load(data[3].imageUrl)
            .into(binding.categoryIv4)
    }
}

