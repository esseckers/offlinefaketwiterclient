package com.esseckers.test.app.offlinefaketwiterclient.presentation.twits

import com.esseckers.test.app.offlinefaketwiterclient.model.interactor.twits.TwitsInteractor
import com.esseckers.test.app.offlinefaketwiterclient.presentation.base.BasePresenter

/**
 * Created by Ivan Danilov.
 */
class TwitsPresenter constructor(
    private val twitsInteractor: TwitsInteractor
) : BasePresenter<TwitsView>() {

}