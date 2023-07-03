package com.hvk.hindistory.di

import com.hvk.hindistory.screens.detail.DetailViewModel
import com.hvk.hindistory.screens.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::DetailViewModel)
}
