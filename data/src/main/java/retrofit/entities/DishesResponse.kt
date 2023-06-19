package retrofit.entities

import com.denisardent.common.entities.Dish
import com.google.gson.annotations.SerializedName

data class DishesResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("description") val description: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("tegs") val tegs: List<String>
){
    fun equalDish(dishId: Int): Boolean{
        return dishId == id
    }

    fun toDish(): Dish{
        return Dish(
            id = id,
            name = name,
            price = price,
            weight =weight,
            description = description,
            imageUrl = imageUrl,
            tegs = tegs
        )
    }
}
