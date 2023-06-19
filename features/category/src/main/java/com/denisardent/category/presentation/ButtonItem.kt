package com.denisardent.category.presentation

import com.denisardent.common.entities.ListItem

data class ButtonItem(
    val buttonText: String,
    val isChecked: Boolean = false
): ListItem
