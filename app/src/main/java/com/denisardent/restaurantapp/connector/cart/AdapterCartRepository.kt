package com.denisardent.restaurantapp.connector.cart

import base.CartDataRepository
import base.RestaurantDataRepository
import com.denisardent.cart.domain.CartRepository
import com.denisardent.common.entities.CartItem
import com.denisardent.common.entities.Dish
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import retrofit.entities.DishesResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdapterCartRepository @Inject constructor(
    private val cartDataRepository: CartDataRepository,
    private val restaurantDataRepository: RestaurantDataRepository
) : CartRepository {

    override suspend fun getCartFlow(): Flow<List<CartItem>> {
        return cartDataRepository.getCartFlow()
    }

    override fun addDishToCart(dish: Dish){
        cartDataRepository.addDishToCart(dish)
    }

    override fun removeDishFromCart(dish: Dish) {
        cartDataRepository.removeFromCart(dish)
    }
}