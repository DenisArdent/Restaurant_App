package com.denisardent.cart.presentation

import com.bumptech.glide.Glide
import com.denisardent.cart.databinding.ItemCartBinding
import com.denisardent.common.entities.CartItem
import com.denisardent.common.entities.ListItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object CartScreenDelegate {
    fun dishDelegate(itemMinusClickedListener : (CartItem) -> Unit,
                     itemPlusClickedListener : (CartItem) -> Unit) = adapterDelegateViewBinding<CartItem, ListItem, ItemCartBinding>(
        {layoutInflater, parent -> ItemCartBinding.inflate(layoutInflater,parent, false) }
    ){
        binding.buttonMinus.setOnClickListener {
            itemMinusClickedListener(item)
        }

        binding.buttonPlus.setOnClickListener {
            itemPlusClickedListener(item)
        }

        bind {
            Glide
                .with(binding.root)
                .load(item.imageUrl)
                .into(binding.dishIv)
            with(binding){
                count.text = item.quantity.toString()
                dishName.text = item.name
                dishCost.text = item.price.toString()+"₽"
                dishWeight.text = item.weight.toString()+"г"
            }
        }
    }
}