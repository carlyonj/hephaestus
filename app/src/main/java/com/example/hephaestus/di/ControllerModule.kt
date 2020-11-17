package com.example.hephaestus.di

import com.example.hephaestus.api.Controller
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ControllerModule {
    @Provides
    @Singleton
    fun provideController(): Controller {
        return Controller()
    }
}