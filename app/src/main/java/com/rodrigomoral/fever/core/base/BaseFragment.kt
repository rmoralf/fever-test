package com.rodrigomoral.fever.core.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

abstract class BaseFragment : Fragment() {
    lateinit var baseActivity: BaseActivity

    //region Lifecycle methods
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        baseActivity = activity as BaseActivity
        return inflater.inflate(getLayoutId(), container, false)
    }
    //endregion

    protected abstract fun getLayoutId(): Int

}