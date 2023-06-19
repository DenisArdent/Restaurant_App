package com.denisardent.restaurantapp.connector.category.di

import com.denisardent.category.domain.DishesRepository
import com.denisardent.main.domain.NavigateToCategories
import com.denisardent.restaurantapp.connector.category.AdapterDishesRepository
import com.denisardent.restaurantapp.connector.category.NavigateToCategoriesAdapter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CategoryRepositoriesModule {
    @Binds
    fun bindNavigateToCategories(navigateToCategories: NavigateToCategoriesAdapter): NavigateToCategories

    @Binds
    fun bindDishesRepository(adapterDishesRepository: AdapterDishesRepository): DishesRepository
}