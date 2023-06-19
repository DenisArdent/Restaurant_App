package retrofit

import com.denisardent.common.entities.Dish
import com.denisardent.common.entities.FoodCategory
import com.google.gson.JsonObject
import okhttp3.Call
import retrofit.entities.CategoriesList
import retrofit.entities.DishesList
import retrofit2.http.GET


interface RestaurantsApi {

    @GET("v3/058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getCategories(): CategoriesList

    @GET("v3/aba7ecaa-0a70-453b-b62d-0e326c859b3b")
    suspend fun getDishes(): DishesList
}