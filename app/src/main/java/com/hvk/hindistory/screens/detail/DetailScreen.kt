package com.hvk.hindistory.screens.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import com.hvk.hindistory.R
import com.hvk.hindistory.components.Loading
import com.hvk.hindistory.components.LoadingView
import com.hvk.hindistory.components.MyImage
import com.hvk.hindistory.data.Detail
import org.koin.androidx.compose.getViewModel

data class DetailScreen(
    val url: String,
) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: DetailViewModel = getViewModel()

        LaunchedEffect(true) {
            viewModel.runScraper(url)
        }

        val detail = viewModel.detail.value
        val loading = viewModel.loading
        if (loading.value) {
            LoadingView()
        } else {
            UI(detail)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    @Composable
    fun UI(detail: Detail?) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(title = {
                    if (detail != null) {
                        Text(
                            text = detail.title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .basicMarquee(),
                        )
                    }
                })
            },
        ) {
            Card(
                modifier = Modifier.fillMaxSize().padding(it),
//                verticalArrangement = Arrangement.Top,
            ) {
                detail?.imageUrl?.let { url -> MyImage(source = url) }

                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                ) {
                    detail?.let { it1 ->
                        items(items = it1.content) { p ->
                            Text(text = p.text)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}
