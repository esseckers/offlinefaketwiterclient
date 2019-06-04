package com.esseckers.test.app.offlinefaketwitterclient.presentation.splash

import com.esseckers.test.app.offlinefaketwitterclient.presentation.base.BaseView

/**
 * Created by Ivan Danilov.
 */
interface SplashView : BaseView {
    fun userLoggedState(isLogged: Boolean)
}