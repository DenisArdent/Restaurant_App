package base

import com.denisardent.common.entities.Dish

interface DishesDataRepository {
    fun addDishToCart(dish: Dish)
}