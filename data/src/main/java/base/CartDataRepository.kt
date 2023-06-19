package base

import com.denisardent.common.entities.CartItem
import com.denisardent.common.entities.Dish
import kotlinx.coroutines.flow.Flow

interface CartDataRepository: DishesDataRepository {

    fun getCartFlow(): Flow<List<CartItem>>

    override fun addDishToCart(dish: Dish)

    fun removeFromCart(dish: Dish)
}