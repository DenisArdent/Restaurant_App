package com.denisardent.restaurantapp.connector.main.di

import com.denisardent.main.domain.CategoriesRepository
import com.denisardent.restaurantapp.connector.main.AdapterCategoriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MainRepositoriesModule {

    @Binds
    fun bindCategoriesRepository(
        adapterCategoriesRepository: AdapterCategoriesRepository
    ): CategoriesRepository
}