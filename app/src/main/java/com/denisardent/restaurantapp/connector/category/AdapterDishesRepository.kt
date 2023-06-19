package com.denisardent.restaurantapp.connector.category

import base.DishesDataRepository
import base.RestaurantDataRepository
import com.denisardent.category.domain.DishesRepository
import com.denisardent.common.ErrorStatusResult
import com.denisardent.common.StatusResult
import com.denisardent.common.SuccessStatusResult
import com.denisardent.common.entities.Dish
import javax.inject.Inject

class AdapterDishesRepository @Inject constructor(
    private val restaurantDataRepository: RestaurantDataRepository,
    private val dishesDataRepository: DishesDataRepository
): DishesRepository {
    override suspend fun getDishesList(): List<Dish>{
        return try {
            val dishesList = restaurantDataRepository.getDishesList()
            dishesList.dishes.map {
                it.toDish()
            }
        } catch (e:Exception){
            throw e
        }
    }

    override fun addDishToCart(dish: Dish) {
        dishesDataRepository.addDishToCart(dish)
    }
}