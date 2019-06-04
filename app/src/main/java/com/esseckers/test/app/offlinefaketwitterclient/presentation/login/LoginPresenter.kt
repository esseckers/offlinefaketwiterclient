package com.esseckers.test.app.offlinefaketwitterclient.presentation.login

import com.esseckers.test.app.offlinefaketwitterclient.R
import com.esseckers.test.app.offlinefaketwitterclient.entity.UserData
import com.esseckers.test.app.offlinefaketwitterclient.model.interactor.user.UserInteractor
import com.esseckers.test.app.offlinefaketwitterclient.presentation.base.BasePresenter
import io.reactivex.rxkotlin.subscribeBy

/**
 * Created by Ivan Danilov.
 */
class LoginPresenter constructor(private val userInteractor: UserInteractor) : BasePresenter<LoginView>() {

    fun saveUser(name: String) = execute(userInteractor.saveUser(UserData(1, name)))
        .subscribeBy(
            onComplete = { viewState.openTwittsScreen() },
            onError = { viewState.showError(R.string.error) })
}