package com.esseckers.test.app.offlinefaketwitterclient.presentation.splash

import com.esseckers.test.app.offlinefaketwitterclient.R
import com.esseckers.test.app.offlinefaketwitterclient.model.interactor.splash.SplashInteractor
import com.esseckers.test.app.offlinefaketwitterclient.presentation.base.BasePresenter
import io.reactivex.rxkotlin.subscribeBy

/**
 * Created by Ivan Danilov.
 */
class SplashPresenter constructor(private val splashInteractor: SplashInteractor) : BasePresenter<SplashView>() {

    override fun onFirstAttach() {
        createTwits()
    }

    fun isUserLogged() = execute(splashInteractor.isUserLogged())
        .subscribeBy(
            onSuccess = {
                viewState.userLoggedState(it)
            },
            onError = {
                viewState.showError(R.string.error)
            }
        )

    private fun createTwits() = execute(splashInteractor.createTwits())
        .subscribeBy(
            onError = {
                viewState.showError(R.string.error)
            }
        )
}