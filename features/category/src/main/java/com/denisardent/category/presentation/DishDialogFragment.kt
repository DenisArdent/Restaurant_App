/*
package com.denisardent.category.presentation

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.denisardent.category.R
import com.denisardent.category.databinding.DialogDishBinding
import com.denisardent.category.domain.DishesRepository
import javax.inject.Inject

class DishDialogFragment: DialogFragment(R.layout.dialog_dish){

    @Inject
    lateinit var dishesRepository: DishesRepository

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DialogDishBinding.bind(view)
        binding.addToCartButton.setOnClickListener {
            dishesRepository.addDishToCart()
        }
    }
}*/
