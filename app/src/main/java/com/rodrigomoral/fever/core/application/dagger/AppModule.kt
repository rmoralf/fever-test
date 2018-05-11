package com.rodrigomoral.fever.core.application.dagger

import com.rodrigomoral.fever.core.application.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

@Module
class AppModule(private val app: App) {
    @Provides
    @Singleton
    fun provideApp() = app
}