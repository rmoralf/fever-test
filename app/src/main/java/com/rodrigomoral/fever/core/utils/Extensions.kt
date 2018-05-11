package com.rodrigomoral.fever.core.utils

import android.app.Activity
import android.support.annotation.LayoutRes
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rodrigomoral.fever.core.application.App

/**
 * Created by Rodrigo Moral Fiel on 11/05/2018
 */

/**
 * Simplifies access to (casted) application
 */
val Activity.app: App
    get() = application as App

/**
 * Simplifies all the fragment_crewlist transactions
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

/**
 * Helps inflating views
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}