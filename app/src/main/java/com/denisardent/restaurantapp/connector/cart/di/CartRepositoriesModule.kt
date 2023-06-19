package com.denisardent.restaurantapp.connector.cart.di

import com.denisardent.cart.domain.CartRepository
import com.denisardent.category.domain.DishesRepository
import com.denisardent.restaurantapp.connector.cart.AdapterCartRepository
import com.denisardent.restaurantapp.connector.category.AdapterDishesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CartRepositoriesModule {
    @Binds
    @Singleton
    fun bindCartRepository(adapterCartRepository: AdapterCartRepository): CartRepository
}