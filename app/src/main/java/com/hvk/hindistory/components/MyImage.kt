package com.hvk.hindistory.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun MyImage(source: Any) {
    when (source) {
        is String -> {
            if (source.isEmpty()) {
                Image(imageVector = Icons.Default.Person, contentDescription = "")
            } else {
                AsyncImage(
                    model = source,
                    modifier = Modifier.fillMaxWidth(),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                )
            }
        }

        is Int -> {
        }
    }
}
