package com.rodrigomoral.fever.main

import android.os.Bundle
import com.rodrigomoral.fever.R
import com.rodrigomoral.fever.core.base.BaseActivity
import com.rodrigomoral.fever.core.utils.app
import com.rodrigomoral.fever.crewlist.CrewFragment
import com.rodrigomoral.fever.main.dagger.MainModule
import javax.inject.Inject

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

class MainActivity : BaseActivity(), MainContract.View {
    //region Dagger
    private val component by lazy { app.component.plus(MainModule(this)) }

    @Inject
    lateinit var mPresenter: MainContract.Presenter
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        loadNewFragment(CrewFragment(), R.id.main_fragment_container, false)
    }

    //region Contract methods
    //endregion

    //region Base methods
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
    //endregion

}
