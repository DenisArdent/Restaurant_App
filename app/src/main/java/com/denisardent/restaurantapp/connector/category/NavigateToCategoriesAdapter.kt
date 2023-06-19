package com.denisardent.restaurantapp.connector.category

import androidx.navigation.NavController
import com.denisardent.main.domain.NavigateToCategories
import com.denisardent.restaurantapp.R
import javax.inject.Inject

class NavigateToCategoriesAdapter @Inject constructor(): NavigateToCategories {
    override fun navigateToCategories(navController: NavController) {
        navController.navigate(R.id.categoryFragment)
    }
}