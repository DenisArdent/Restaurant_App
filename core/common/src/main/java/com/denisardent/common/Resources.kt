package com.denisardent.common

interface Resources {
    fun getString(id: Int): String

    fun getString(id: Int, vararg placeholders: Any): String

}