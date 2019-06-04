package com.esseckers.test.app.offlinefaketwitterclient.presentation.login

import com.esseckers.test.app.offlinefaketwitterclient.R
import com.esseckers.test.app.offlinefaketwitterclient.presentation.Screens
import com.esseckers.test.app.offlinefaketwitterclient.presentation.base.BaseFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragm_login.*
import org.koin.android.ext.android.inject

/**
 * Created by Ivan Danilov.
 */
class LoginFragment : BaseFragment<LoginView, LoginPresenter>(), LoginView {
    override fun openTwittsScreen() {
        appActivity.router.newRootScreen(Screens.TwitsScreen)
    }

    val loginPresenter: LoginPresenter by inject()

    override val presenter: LoginPresenter
        get() = loginPresenter

    override val layoutRes = R.layout.fragm_login

    override fun initView() {
        btnLogin.setOnClickListener {
            presenter.saveUser(edName.text.toString())
        }
    }

    override fun showError(errorRes: Int) {
        Snackbar.make(loginScreen, errorRes, Snackbar.LENGTH_LONG).show()
    }
}