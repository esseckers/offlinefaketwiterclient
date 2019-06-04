package com.esseckers.test.app.offlinefaketwitterclient.presentation.splash

import android.os.Handler
import com.esseckers.test.app.offlinefaketwitterclient.R
import com.esseckers.test.app.offlinefaketwitterclient.presentation.Screens
import com.esseckers.test.app.offlinefaketwitterclient.presentation.base.BaseFragment
import org.koin.android.ext.android.inject


/**
 * Created by Ivan Danilov.
 */
class SplashFragment : BaseFragment<SplashView, SplashPresenter>(), SplashView {

    val loginPresenter: SplashPresenter by inject()

    override val presenter: SplashPresenter
        get() = loginPresenter

    override val layoutRes = R.layout.fragm_splash

    override fun initView() {
        presenter.isUserLogged()
    }

    override fun userLoggedState(isLogged: Boolean) {
        Handler().postDelayed(
            {
                appActivity.router.newRootScreen(if (isLogged) Screens.TwitsScreen else Screens.LoginScreen)
            }, 2000
        )
    }
}