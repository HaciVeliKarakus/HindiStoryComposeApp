package com.hvk.hindistory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import com.hvk.hindistory.screens.main.MainScreen
import com.hvk.hindistory.ui.theme.HindiStoryComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HindiStoryComposeAppTheme {
                Navigator(MainScreen())
            }
        }
    }
}
