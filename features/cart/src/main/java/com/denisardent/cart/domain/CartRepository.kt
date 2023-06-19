package com.denisardent.cart.domain

import com.denisardent.common.entities.CartItem
import com.denisardent.common.entities.Dish
import kotlinx.coroutines.flow.Flow


interface CartRepository {
    suspend fun getCartFlow(): Flow<List<CartItem>>

    fun addDishToCart(dish: Dish)

    fun removeDishFromCart(dish: Dish)
}