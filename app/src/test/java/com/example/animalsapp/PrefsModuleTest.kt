package com.example.animalsapp

import android.app.Application
import com.example.animalsapp.di.PrefsModule
import com.example.animalsapp.util.SharedPreferencesHelper

class PrefsModuleTest(val mocksPrefs : SharedPreferencesHelper) : PrefsModule() {
    override fun provideSharedPreferences(app: Application): SharedPreferencesHelper {
        return mocksPrefs
    }
}