package com.hvk.hindistory.remote

import android.util.Log
import com.hvk.hindistory.data.Story
import it.skrape.core.htmlDocument
import it.skrape.fetcher.AsyncFetcher
import it.skrape.fetcher.response
import it.skrape.fetcher.skrape

class SkrapeHandler {

    suspend fun collectData(

        onStoriesCollected: (List<Story>) -> Unit,
        onFail: (java.lang.Exception) -> Unit = {},
    ) {
        try {
            collectData(onStoriesCollected)
        } catch (e: Exception) {
            Log.i("DATA", "Skrap data FAILED!!!")
            onFail(e)
        }
    }

    private suspend fun collectData(
        onStoriesCollected: (List<Story>) -> Unit,
    ) {
        skrape(AsyncFetcher) {
            request {
                url = "https://shortstoriesinhindi.com/"
            }
            response {
                htmlDocument {
                    val titles = findAll(".post-title.entry-title")
                    titles.forEach {
                        println(">>>>>> ${it.text}")
                        println(">>>>>> ${it.eachHref.first()}")
                        val stories = ArrayList<Story>()
//                        stories.add(
//                            Story(
//                                title = it.text,
//                                url = it.eachHref[0],
//                                date = date,
//                                imageUrl = imageUrl,
//                            ),
//                        )
                        onStoriesCollected(stories)
                    }
                }
            }
        }
    }
}
