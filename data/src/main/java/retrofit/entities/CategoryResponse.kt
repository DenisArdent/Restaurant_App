package retrofit.entities

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    val id: Int,
    val name: String,
    @SerializedName("image_url") val imageUrl: String
)
