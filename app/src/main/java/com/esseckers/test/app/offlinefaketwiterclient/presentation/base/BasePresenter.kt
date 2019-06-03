package com.esseckers.test.app.offlinefaketwiterclient.presentation.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Ivan Danilov.
 */
open class BasePresenter<V : BaseView> {

    private val compositeDisposable = CompositeDisposable()

    fun onDestroy() {
        compositeDisposable.dispose()
    }

    protected fun Disposable.connect() {
        compositeDisposable.add(this)
    }
}