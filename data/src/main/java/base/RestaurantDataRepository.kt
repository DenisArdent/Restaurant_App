package base

import com.denisardent.common.entities.Dish
import com.denisardent.common.entities.FoodCategory
import retrofit.entities.DishesList

interface RestaurantDataRepository {

    suspend fun getCategoriesList(): List<FoodCategory>

    suspend fun getDishesList(): DishesList
}