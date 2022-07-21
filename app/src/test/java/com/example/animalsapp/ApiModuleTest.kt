package com.example.animalsapp

import com.example.animalsapp.di.ApiModule
import com.example.animalsapp.model.AnimalApiService

class ApiModuleTest(val mockService : AnimalApiService) : ApiModule(){
    override fun provideAnimalApiService(): AnimalApiService {
        return mockService
    }
}