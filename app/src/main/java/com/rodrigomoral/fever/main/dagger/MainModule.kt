package com.rodrigomoral.fever.main.dagger

import com.rodrigomoral.fever.core.application.dagger.BaseScope
import com.rodrigomoral.fever.main.MainContract
import com.rodrigomoral.fever.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

@Module
class MainModule(private val mView: MainContract.View) {

    @Provides
    @BaseScope
    fun providesMainPresenter(view: MainContract.View): MainContract.Presenter = MainPresenter(view)

    @Provides
    @BaseScope
    fun providesMainView(): MainContract.View = mView

}