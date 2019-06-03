package com.esseckers.test.app.offlinefaketwiterclient.presentation.login

import com.esseckers.test.app.offlinefaketwiterclient.model.interactor.user.UserInteractor
import com.esseckers.test.app.offlinefaketwiterclient.presentation.base.BasePresenter
import com.esseckers.test.app.offlinefaketwiterclient.presentation.twits.TwitsView

/**
 * Created by Ivan Danilov.
 */
class LoginPresenter constructor(
    private val userInteractor: UserInteractor
) : BasePresenter<TwitsView>() {

}