package com.rodrigomoral.fever.core.application.dagger

import com.rodrigomoral.fever.core.application.App
import com.rodrigomoral.fever.crewlist.dagger.CrewComponent
import com.rodrigomoral.fever.crewlist.dagger.CrewModule
import com.rodrigomoral.fever.main.dagger.MainComponent
import com.rodrigomoral.fever.main.dagger.MainModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)

    fun plus(mainModule: MainModule): MainComponent
    fun plus(fragmentModule: CrewModule): CrewComponent

}