package com.rodrigomoral.fever.crewlist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.rodrigomoral.fever.R
import com.rodrigomoral.fever.core.base.BaseFragment
import com.rodrigomoral.fever.core.utils.app
import com.rodrigomoral.fever.crewlist.dagger.CrewModule
import kotlinx.android.synthetic.main.fragment_crewlist.*
import javax.inject.Inject

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

class CrewFragment : BaseFragment(), CrewContract.View {

    //region Dagger
    private val component by lazy { activity?.app?.component?.plus(CrewModule(this)) }

    @Inject
    lateinit var mPresenter: CrewContract.Presenter
    //endregion

    lateinit var mAdapter: CrewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        component?.inject(this)

        mPresenter.generateCrewMembers()

        order_alphabetical.setOnClickListener { mPresenter.sortById() }
        order_position.setOnClickListener { mPresenter.sortByPosition() }
    }
    //endregion

    //region Contract methods
    override fun createAdapter() {
        mAdapter = CrewAdapter(mPresenter as CrewPresenter)
        recyclerview.adapter = mAdapter
        recyclerview.layoutManager = LinearLayoutManager(activity)
    }

    override fun updateList() {
        mAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        loading_layer.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading_layer.visibility = View.GONE
    }
    //endregion

    //region Base methods
    override fun getLayoutId(): Int {
        return R.layout.fragment_crewlist
    }
    //endregion
}