package com.hvk.hindistory.data

import it.skrape.selects.DocElement

data class Detail(
    val title: String,
    val content: List<DocElement>,
    val imageUrl: String?,
    val date: String
)
