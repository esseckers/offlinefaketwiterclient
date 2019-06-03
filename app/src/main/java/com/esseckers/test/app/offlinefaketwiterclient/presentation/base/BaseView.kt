package com.esseckers.test.app.offlinefaketwiterclient.presentation.base

import android.support.annotation.StringRes

/**
 * Created by Ivan Danilov.
 */
interface BaseView {

    fun showError(@StringRes errorRes: Int)
    fun showLoadingProgress(visibility: Int)

}