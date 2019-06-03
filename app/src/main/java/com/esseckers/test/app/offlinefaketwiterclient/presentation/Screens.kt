package com.esseckers.test.app.offlinefaketwiterclient.presentation

import com.esseckers.test.app.offlinefaketwiterclient.presentation.login.LoginFragment
import com.esseckers.test.app.offlinefaketwiterclient.presentation.splash.SplashFragment
import com.esseckers.test.app.offlinefaketwiterclient.presentation.twits.TwitsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

/**
 * Created by Ivan Danilov.
 */
object Screens {

    object SplashScreen : SupportAppScreen() {
        override fun getFragment() = SplashFragment()
    }

    object LoginScreen : SupportAppScreen() {
        override fun getFragment() = LoginFragment()
    }

    object TwitsScreen : SupportAppScreen() {
        override fun getFragment() = TwitsFragment()
    }
}