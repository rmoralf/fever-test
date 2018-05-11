package com.rodrigomoral.fever.crewlist

import com.rodrigomoral.fever.core.base.BaseContract

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

class CrewContract : BaseContract() {

    interface View : BaseContractView {
        fun createAdapter()
        fun updateList()

        fun showLoading()
        fun hideLoading()
    }

    interface Presenter : BaseContractPresenter {
        fun generateCrewMembers()

        fun sortById()
        fun sortByPosition()

        //Adapter methods
        fun onBindViewHolderAtPosition(viewHolder: CrewViewHolder, position: Int)

        fun getCrewCount(): Int
    }

    interface Adapter {
        fun setPositionColor(color: Int)
        fun setCrewId(id: String)
        fun setRace(race: String)
        fun setMultiplier(multiplier: String)
    }
}