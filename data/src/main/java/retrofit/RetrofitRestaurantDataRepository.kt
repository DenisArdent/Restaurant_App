package retrofit

import android.util.Log
import base.RestaurantDataRepository
import base.BaseRetrofitRepository
import com.denisardent.common.entities.Dish
import com.denisardent.common.entities.FoodCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit.entities.DishesList
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitRestaurantDataRepository @Inject constructor(
    retrofit: Retrofit
): BaseRetrofitRepository(), RestaurantDataRepository {

    private val restaurantsApi = retrofit.create(RestaurantsApi::class.java)

    override suspend fun getCategoriesList(): List<FoodCategory> {
        return withContext(Dispatchers.IO){
            restaurantsApi.getCategories().categories.map {
                FoodCategory(
                    it.id,
                    it.name,
                    it.imageUrl
                )
            }
        }
    }

    override suspend fun getDishesList(): DishesList {
        return withContext(Dispatchers.IO){
            restaurantsApi.getDishes()
        }
    }


}
