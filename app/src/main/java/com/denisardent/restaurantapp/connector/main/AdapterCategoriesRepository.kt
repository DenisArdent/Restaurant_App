package com.denisardent.restaurantapp.connector.main

import base.RestaurantDataRepository
import com.denisardent.common.ErrorStatusResult
import com.denisardent.common.StatusResult
import com.denisardent.common.SuccessStatusResult
import com.denisardent.common.entities.FoodCategory
import com.denisardent.main.domain.CategoriesRepository
import javax.inject.Inject

class AdapterCategoriesRepository @Inject constructor(
    private val restaurantDataRepository: RestaurantDataRepository
): CategoriesRepository {
    override suspend fun getCategoriesList(): StatusResult<List<FoodCategory>> {
        return try {
            SuccessStatusResult(restaurantDataRepository.getCategoriesList())
        } catch (e: Exception){
            ErrorStatusResult(e)
        }

    }
}