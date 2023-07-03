package com.hvk.hindistory.data

data class Story(
    val title: String,
    val url: String,
    val date: String,
    val imageUrl: String,
    val category: Category,
    val preview: String,
) {
    data class Category(
        val name: String,
        val url: String,
    )
}
