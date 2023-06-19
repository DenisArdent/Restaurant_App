package com.denisardent.cart.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denisardent.cart.domain.CartRepository
import com.denisardent.common.entities.CartItem
import com.denisardent.common.entities.Dish
import com.denisardent.common.entities.DishItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(): ViewModel() {
    private val _state = MutableStateFlow<List<CartItem>>(emptyList())
    val state: StateFlow<List<CartItem>> = _state.asStateFlow()

    @Inject
    lateinit var cartRepository: CartRepository

    init {
        viewModelScope.launch {
            cartRepository.getCartFlow().collectLatest {
                println(it)
                _state.tryEmit(it)
            }
        }
    }

    fun addToCart(dish: Dish){
        cartRepository.addDishToCart(dish)
    }

    fun removeFromCart(dish: Dish){
        cartRepository.removeDishFromCart(dish)
    }
}