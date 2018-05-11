package com.rodrigomoral.fever.crewlist

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.rodrigomoral.fever.R
import kotlinx.android.synthetic.main.item_list_cell.view.*

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */
class CrewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), CrewContract.Adapter {
    override fun setPositionColor(color: Int) {
        itemView.item_position.setBackgroundColor(ContextCompat.getColor(itemView.context, color))
    }

    override fun setCrewId(id: String) {
        itemView.item_crew_id.text = itemView.context.getString(R.string.item_crew_id, id)
    }

    override fun setRace(race: String) {
        itemView.item_race.text = race
    }

    override fun setMultiplier(multiplier: String) {
        itemView.item_race_multiplier.text = multiplier
    }

}