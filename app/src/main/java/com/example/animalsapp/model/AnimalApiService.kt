package com.example.animalsapp.model


import com.example.animalsapp.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class AnimalApiService {

    @Inject
    lateinit var api : AnimalApi
    init{
        DaggerApiComponent.create().inject(this)
    }

    fun getApiKey() : Single<ApiKey> {
        return api.getApiKey()
    }

    fun getAnimals(key : String) : Single<List<Animal>>{
        return api.getAnimals(key)
    }

}