package com.rodrigomoral.fever.main.dagger

import com.rodrigomoral.fever.core.application.dagger.BaseScope
import com.rodrigomoral.fever.main.MainActivity
import dagger.Subcomponent

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

@BaseScope
@Subcomponent(modules = [MainModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}