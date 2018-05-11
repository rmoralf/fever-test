package com.rodrigomoral.fever.crewlist.dagger

import com.rodrigomoral.fever.core.application.dagger.BaseScope
import com.rodrigomoral.fever.crewlist.CrewContract
import com.rodrigomoral.fever.crewlist.CrewPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

@Module
class CrewModule(private val mView: CrewContract.View) {

    @Provides
    @BaseScope
    fun providesFragmentPresenter(view: CrewContract.View): CrewContract.Presenter = CrewPresenter(view)

    @Provides
    @BaseScope
    fun providesFragmentView(): CrewContract.View = mView
}