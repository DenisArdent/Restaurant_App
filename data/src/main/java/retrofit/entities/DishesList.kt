package retrofit.entities

import com.google.gson.annotations.SerializedName

data class DishesList(
    @SerializedName("dishes") val dishes: List<DishesResponse>
)
