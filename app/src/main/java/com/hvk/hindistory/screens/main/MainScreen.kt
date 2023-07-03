package com.hvk.hindistory.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.hvk.hindistory.R
import com.hvk.hindistory.components.Loading
import com.hvk.hindistory.components.LoadingView
import com.hvk.hindistory.components.MyImage
import com.hvk.hindistory.data.Story
import com.hvk.hindistory.screens.detail.DetailScreen
import org.koin.androidx.compose.getViewModel

class MainScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: MainViewModel = getViewModel()
        val stories = viewModel.stories
        val loading = viewModel.loading

        if (loading.value) {
            LoadingView()
        } else {
            UI(stories = stories)
        }
    }

    @Composable
    fun UI(
        stories: List<Story>,
    ) {
        val navigator = LocalNavigator.currentOrThrow

        Column {
            LazyColumn(
                modifier = Modifier.padding(16.dp),
            ) {
                itemsIndexed(items = stories) { index, story ->
                    StoryRow(story) {
                        navigator.push(DetailScreen(story.url))
                    }
                    if (index < stories.size - 1) {
                        Divider(thickness = 1.dp)
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun StoryRow(
        story: Story,
        onStorySelected: () -> Unit,
    ) {
        Log.d("StoryRow", "StoryRow: ${story.title}")

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            onClick = onStorySelected,
        ) {
            MyImage(story.imageUrl)
            Column(
                Modifier.padding(16.dp),
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = story.category.name,
                    fontSize = 8.sp,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = story.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = story.preview,
                    fontSize = 12.sp,
                )
            }
        }
    }
}
