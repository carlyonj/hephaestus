package com.example.hephaestus.di

import com.example.hephaestus.api.Controller
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ControllerModule::class))
interface ControllerComponent {
    fun getController(): Controller
}