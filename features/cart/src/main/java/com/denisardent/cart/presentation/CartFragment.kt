package com.denisardent.cart.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.denisardent.cart.R
import com.denisardent.cart.databinding.FragmentCartBinding
import com.denisardent.common.entities.CartItem
import com.denisardent.common.entities.ListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CartFragment: Fragment(R.layout.fragment_cart) {

    private val viewModel: CartViewModel by viewModels()
    lateinit var binding: FragmentCartBinding

    private val adapter = ListDelegationAdapter<List<ListItem>>(
        CartScreenDelegate.dishDelegate({cartItem ->
            viewModel.removeFromCart(cartItem.toDish())
        },{
            viewModel.addToCart(it.toDish())
        })
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCartBinding.bind(view)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest {
                    with(binding){
                        adapter.apply {
                            items = it
                            notifyDataSetChanged()
                        }
                        recyclerView.adapter = adapter
                    }
                }
            }
        }
    }
}