package com.denisardent.main.domain

import com.denisardent.common.StatusResult
import com.denisardent.common.entities.FoodCategory
import kotlinx.coroutines.flow.Flow


interface CategoriesRepository {

    suspend fun getCategoriesList(): StatusResult<List<FoodCategory>>
}