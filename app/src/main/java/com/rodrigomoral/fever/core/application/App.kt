package com.rodrigomoral.fever.core.application

import android.app.Application
import com.rodrigomoral.fever.core.application.dagger.AppComponent
import com.rodrigomoral.fever.core.application.dagger.AppModule
import com.rodrigomoral.fever.core.application.dagger.DaggerAppComponent

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

class App : Application() {

    val component: AppComponent  by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}