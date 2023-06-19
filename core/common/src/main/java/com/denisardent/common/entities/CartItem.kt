package com.denisardent.common.entities

class CartItem(
    val id: Int,
    val name: String,
    val price: Int,
    val weight: Int,
    val description: String,
    val imageUrl: String,
    var quantity: Int = 0
) : ListItem {
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
        fun fromDish(dish: Dish, quantity: Int): CartItem {
            return CartItem(
                dish.id,
                dish.name,
                dish.price,
                dish.weight,
                dish.description, dish.imageUrl, quantity
            )
        }
    }
}