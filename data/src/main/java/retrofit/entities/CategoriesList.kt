package retrofit.entities

import com.denisardent.common.entities.FoodCategory
import com.google.gson.annotations.SerializedName

class CategoriesList(
    @SerializedName("сategories")val categories: Array<CategoryResponse>
)