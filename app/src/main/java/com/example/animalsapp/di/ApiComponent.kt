package com.example.animalsapp.di

import com.example.animalsapp.model.AnimalApiService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service : AnimalApiService)
}