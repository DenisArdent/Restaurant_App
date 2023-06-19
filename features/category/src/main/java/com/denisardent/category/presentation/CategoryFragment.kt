package com.denisardent.category.presentation

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.denisardent.category.R
import com.denisardent.category.databinding.DialogDishBinding
import com.denisardent.category.databinding.FragmentCategoryBinding
import com.denisardent.common.entities.DishItem
import com.denisardent.common.entities.ListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CategoryFragment: Fragment(R.layout.fragment_category) {

    lateinit var binding: FragmentCategoryBinding


    private val viewModel: CategoryViewModel by viewModels()

    private val adapter = ListDelegationAdapter<List<ListItem>>(
        CategoryScreenDelegates.buttonsHorizontalDelegate,
        CategoryScreenDelegates.dishesVerticalDelegate{dishItem ->
            createDishDialog(dishItem)

        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoryBinding.bind(view)

        viewLifecycleOwner.lifecycleScope.launch {

            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.categoryState.collectLatest {
                    with(binding){
                        recyclerView.adapter = adapter

                        adapter.apply {
                            items = listOf(ButtonsHorizontalItem
                                (
                                listOf(ButtonItem("Все меню"), ButtonItem("Салаты"),
                                    ButtonItem("С рисом"), ButtonItem("С рыбой"), ButtonItem("Роллы"),
                                )),
                                DishesVerticalItem(
                                    it
                                ),
                            )
                            notifyDataSetChanged()
                        }
                    }
                }
            }
        }
    }

    fun createDishDialog(dishItem: DishItem){
        val dialog = Dialog(requireContext())
        val dialogDishBinding: DialogDishBinding = DialogDishBinding.inflate(layoutInflater)
        Glide.with(dialogDishBinding.root)
            .load(dishItem.imageUrl)
            .into(dialogDishBinding.dishIv)
        with(dialogDishBinding){
            dishName.text = dishItem.name
            dishCost.text = dishItem.price.toString()+"₽"
            dishDescription.text = dishItem.description
            dishWeight.text = dishItem.weight.toString()+"г"
        }
        dialogDishBinding.addToCartButton.setOnClickListener {
            viewModel.addToCart(dishItem.toDish())
            dialog.dismiss()
        }
        dialogDishBinding.closeButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setContentView(dialogDishBinding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

}