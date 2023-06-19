package com.denisardent.common.entities

data class DishItem(
    val id: Int,
    val name: String,
    val price: Int,
    val weight: Int,
    val description: String,
    val imageUrl: String
): ListItem {
    fun toDish(): Dish{
        return Dish(
            id,
            name,
            price,
            weight,
            description,
            imageUrl
        )
    }

    companion object{
        fun fromDish(dish: Dish): DishItem {
            return DishItem(
                dish.id,
                dish.name,
                dish.price,
                dish.weight,
                dish.description,
                dish.imageUrl
            )
        }
    }
}