package com.rodrigomoral.fever.crewlist

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.rodrigomoral.fever.R
import com.rodrigomoral.fever.core.utils.inflate

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

class CrewAdapter(val presenter: CrewPresenter) : RecyclerView.Adapter<CrewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CrewViewHolder(parent.inflate(R.layout.item_list_cell))

    override fun getItemCount(): Int = presenter.getCrewCount()

    override fun onBindViewHolder(holder: CrewViewHolder, position: Int) = presenter.onBindViewHolderAtPosition(holder, holder.adapterPosition)
}