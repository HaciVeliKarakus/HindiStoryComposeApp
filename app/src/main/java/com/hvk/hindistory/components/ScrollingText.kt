package com.hvk.hindistory.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScrollingText(text: String) {
    var offset by remember { mutableStateOf(0f) }

    val infiniteTransition = rememberInfiniteTransition(label = "")
    val animatedOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -200f, // Hareketin sağdan sola doğru gerçekleşeceği mesafe
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart,
        ),
        label = "",
    )

    LaunchedEffect(animatedOffset) {
        offset = animatedOffset
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End,
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .offset(x = offset.dp),
        ) {
            Text(text = text)
        }
    }
}
