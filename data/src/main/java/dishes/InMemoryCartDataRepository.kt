package dishes

import base.CartDataRepository
import base.DishesDataRepository
import base.RestaurantDataRepository
import com.denisardent.common.entities.CartItem
import com.denisardent.common.entities.Dish
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InMemoryCartDataRepository @Inject constructor(): CartDataRepository {

    var dishesMap = mutableListOf<CartItem>()
    val dishesFlow = MutableStateFlow<List<CartItem>>(emptyList())


    override fun addDishToCart(dish: Dish) {
        try {
            dishesMap.first{
                it.id == dish.id
            }.quantity+=1
        }catch (e:Exception){
            dishesMap.add(
                CartItem.fromDish(dish, 1)
            )
        }
        val newDishesMap = dishesMap

        dishesFlow.tryEmit(newDishesMap)
    }

    override fun removeFromCart(dish: Dish) {
        dishesMap.first {
            it.id == dish.id
        }.quantity-=1

        dishesMap = dishesMap.filter {
            it.quantity > 0
        }.toMutableList()

        dishesFlow.tryEmit(dishesMap)
    }

    override fun getCartFlow(): Flow<List<CartItem>> = dishesFlow
}