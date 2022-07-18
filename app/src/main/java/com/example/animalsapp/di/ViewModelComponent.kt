package com.example.animalsapp.di

import com.example.animalsapp.viewmodel.ListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, PrefsModule::class, AppModule::class])
interface ViewModelComponent {

    fun inject(viewModel : ListViewModel) //type is important
}