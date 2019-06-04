package com.esseckers.test.app.offlinefaketwitterclient.presentation

import com.esseckers.test.app.offlinefaketwitterclient.presentation.login.LoginFragment
import com.esseckers.test.app.offlinefaketwitterclient.presentation.splash.SplashFragment
import com.esseckers.test.app.offlinefaketwitterclient.presentation.twits.TweetsFragment
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
        override fun getFragment() = TweetsFragment()
    }
}