package com.hvk.hindistory.screens.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hvk.hindistory.data.Detail
import it.skrape.core.htmlDocument
import it.skrape.fetcher.AsyncFetcher
import it.skrape.fetcher.response
import it.skrape.fetcher.skrape
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    var detail = mutableStateOf<Detail?>(null)
        private set

    val loading = mutableStateOf(true)

    fun runScraper(storyUrl: String) {
        viewModelScope.launch {
            loading.value = true

            skrape(AsyncFetcher) {
                request {
                    url = storyUrl
                }
                response {
                    htmlDocument {
//                        val posts = findAll(".post-inner.post-hover")
//                        posts.forEach {
                        println("----------")
//                            val imageUrl = it.findFirst(".post-thumbnail > a").eachSrc[1]
//                            println(">>>>>> image : $imageUrl")
//                            val url = it.eachHref.first()
//                            println(">>>>>> url: $url")
//                            val categoryName = it.findFirst(".post-category").text
//                            println(">>>>>> category : $categoryName")
//                            val categoryUrl = it.findFirst(".post-category").eachHref[0]
//                            println(">>>>>> category-url : $categoryUrl")
//                            val date = it.findFirst(".post-date").text
//                            println(">>>>>> date : $date")
                        val title = findFirst(".post-title.entry-title").text
                        println(">>>>>> title : $title")
                        val content = findFirst(".entry-inner")

//                        println(content)

//                        val img = findFirst(".wp-caption.aligncenter")
                        val mainImg = content.eachSrc.find { it.contains("shortstoriesinhindi") }
                        println(">>>>> img : $mainImg")
                        val paragraph = content.findAll("p")
                        println(">>> >> content : $paragraph")

                        detail.value = Detail(
                            title = title,
                            content = paragraph,
                            imageUrl = mainImg,
                            date = "",
                        )
//                            val preview = findFirst(".entry.excerpt.entry-summary > p").text
//                            println(">>>>>> prev : $preview")
//                            story.value = Story(
//                                title = title,
//                                url = url,
//                                imageUrl = imageUrl,
//                                date = date,
//                                preview = preview,
//                                category = Story.Category(
//                                    name = categoryName,
//                                    url = categoryUrl,
//                                ),
//                            )
//                        }
                    }
                }
            }
            loading.value = false
        }
    }
}
