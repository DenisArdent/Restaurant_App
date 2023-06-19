package com.denisardent.category.domain

import com.denisardent.common.StatusResult
import com.denisardent.common.entities.Dish

interface DishesRepository {

    suspend fun getDishesList(): List<Dish>

    fun addDishToCart(dish: Dish)
}