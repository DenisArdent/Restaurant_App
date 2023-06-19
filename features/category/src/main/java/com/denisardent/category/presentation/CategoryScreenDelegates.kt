package com.denisardent.category.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.denisardent.category.databinding.ItemButtonBinding
import com.denisardent.category.databinding.ItemButtonsHorizontalBinding
import com.denisardent.category.databinding.ItemDishBinding
import com.denisardent.category.databinding.ItemDishesVerticalBinding
import com.denisardent.common.entities.DishItem
import com.denisardent.common.entities.ListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object CategoryScreenDelegates {

    private val buttonDelegate= adapterDelegateViewBinding<ButtonItem, ListItem, ItemButtonBinding>(
        {layoutInflater, parent -> ItemButtonBinding.inflate(layoutInflater,parent, false) }
    ){
        binding.categoryButton.setOnClickListener {
            if (item.isChecked){

            }
        }
        bind {
            binding.categoryButton.text = item.buttonText
        }
    }

    private val horizontalButtonsAdapter = ListDelegationAdapter(
        buttonDelegate
    )

    val buttonsHorizontalDelegate = adapterDelegateViewBinding<ButtonsHorizontalItem, ListItem, ItemButtonsHorizontalBinding>(
        { layoutInflater, parent->  ItemButtonsHorizontalBinding.inflate(layoutInflater, parent,false).apply {
            this.recyclerView.adapter = horizontalButtonsAdapter
        } }
    ){
        bind {
            (binding.recyclerView.adapter as ListDelegationAdapter<List<ListItem>>).apply {
                items = item.buttons
                notifyDataSetChanged()
            }
         }
    }

    private fun dishDelegate(itemClickedListener : (DishItem) -> Unit) = adapterDelegateViewBinding<DishItem, ListItem, ItemDishBinding>(
        {layoutInflater, parent -> ItemDishBinding.inflate(layoutInflater,parent, false) }
    ){
        binding.root.setOnClickListener {
            itemClickedListener(item)
        }
        bind {
            Glide
                .with(binding.root)
                .load(item.imageUrl)
                .into(binding.dishIv)
            binding.dishName.text = item.name
        }
    }

    private fun verticalDishAdapter(itemClickedListener : (DishItem) -> Unit) = ListDelegationAdapter(
        dishDelegate(itemClickedListener)
    )

    fun dishesVerticalDelegate(onDishClicked: (DishItem) -> Unit) = adapterDelegateViewBinding<DishesVerticalItem, ListItem, ItemDishesVerticalBinding>(
        { layoutInflater: LayoutInflater, parent: ViewGroup ->  ItemDishesVerticalBinding.inflate(layoutInflater, parent,false).apply {
            this.recyclerView.adapter = verticalDishAdapter(onDishClicked)
        } }
    ){
        bind {
            (binding.recyclerView.adapter as ListDelegationAdapter<List<ListItem>>).apply {
                items = item.dishes
                notifyDataSetChanged()
            }
        }
    }
}