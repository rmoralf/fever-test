package com.rodrigomoral.fever.crewlist.dagger

import com.rodrigomoral.fever.core.application.dagger.BaseScope
import com.rodrigomoral.fever.crewlist.CrewFragment
import dagger.Subcomponent

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

@BaseScope
@Subcomponent(modules = [CrewModule::class])
interface CrewComponent {
    fun inject(fragment: CrewFragment)
}