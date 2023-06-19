package com.denisardent.category.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denisardent.category.domain.DishesRepository
import com.denisardent.common.entities.Dish
import com.denisardent.common.entities.DishItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(): ViewModel() {

    private val _categoryState = MutableStateFlow<List<DishItem>>(listOf())
    var categoryState: StateFlow<List<DishItem>> = _categoryState.asStateFlow()

    @Inject
    lateinit var dishesRepository: DishesRepository

    init {
        viewModelScope.launch {
            _categoryState.tryEmit(dishesRepository.getDishesList().map { DishItem.fromDish(it) })
        }
    }

    fun addToCart(dish: Dish){
        dishesRepository.addDishToCart(dish)
    }
}