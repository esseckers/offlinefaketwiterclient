package com.esseckers.test.app.offlinefaketwitterclient.presentation.base

import androidx.annotation.StringRes

/**
 * Created by Ivan Danilov.
 */
interface BaseView {

    fun showError(@StringRes errorRes: Int)
    fun showLoadingProgress(visibility: Int)

}