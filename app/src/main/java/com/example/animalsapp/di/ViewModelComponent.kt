package com.example.animalsapp.di

import com.example.animalsapp.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ViewModelComponent {

    fun inject(viewModel : ListViewModel) //type is important
}