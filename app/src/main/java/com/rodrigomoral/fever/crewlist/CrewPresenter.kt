package com.rodrigomoral.fever.crewlist

import com.rodrigomoral.fever.R
import com.rodrigomoral.fever.core.base.BasePresenter
import com.rodrigomoral.fever.model.CrewData
import com.rodrigomoral.fever.model.determineMultiplier
import com.rodrigomoral.fever.model.generateRandomCrewMember
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */
class CrewPresenter(private val mView: CrewContract.View) : BasePresenter(mView), CrewContract.Presenter {
    var crewList = emptyList<CrewData>()

    //region Contract methods
    override fun generateCrewMembers() {
        mView.showLoading()

        doAsync {
            for (i in 0..450) {
                crewList += (generateRandomCrewMember(i))
            }
            uiThread {
                mView.createAdapter()
                mView.hideLoading()
            }
        }
    }

    override fun sortById() {
        mView.showLoading()
        doAsync {
            crewList = crewList.sortedWith(compareBy { it.crewId })
            uiThread {
                mView.updateList()
                mView.hideLoading()
            }
        }
    }

    override fun sortByPosition() {
        mView.showLoading()
        doAsync {
            crewList = crewList.sortedWith(compareBy({ it.position }, { it.crewId }))
            uiThread {
                mView.updateList()
                mView.hideLoading()
            }
        }
    }
    //endregion

    //region Adapter methods
    override fun onBindViewHolderAtPosition(viewHolder: CrewViewHolder, position: Int) {
        val crewMember = crewList[position]
        viewHolder.setCrewId(crewMember.crewId.toString())
        viewHolder.setRace(crewMember.race)

        when (crewMember.position) {
            0 -> viewHolder.setPositionColor(R.color.command) //Command
            1 -> viewHolder.setPositionColor(R.color.science) //Science
            2 -> viewHolder.setPositionColor(R.color.engineering) //Engineering
        }
        viewHolder.setMultiplier(determineMultiplier(crewMember.position, crewMember.race))
    }

    override fun getCrewCount(): Int = crewList.size
    //endregion

}