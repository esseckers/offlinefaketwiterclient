package com.esseckers.test.app.offlinefaketwitterclient.presentation.base

import com.esseckers.test.app.offlinefaketwitterclient.model.applySchedulersIoToMainForCompletable
import com.esseckers.test.app.offlinefaketwitterclient.model.applySchedulersIoToMainForSingle
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Ivan Danilov.
 */
abstract class BasePresenter<V : BaseView> {
    open lateinit var viewState: V

    private lateinit var compositeDisposable: CompositeDisposable

    fun onAttachView(view: V) {
        viewState = view
        compositeDisposable = CompositeDisposable()
        onFirstAttach()
    }

    open fun onFirstAttach() {

    }

    fun onDestroyView() {
        compositeDisposable.dispose()
    }

    protected open fun <DATA> execute(single: Single<DATA>): Single<DATA> {
        return single.doOnSubscribe { compositeDisposable.add(it) }
            .compose(applySchedulersIoToMainForSingle())
    }

    protected open fun execute(comparable: Completable): Completable {
        return comparable.doOnSubscribe { compositeDisposable.add(it) }
            .compose(applySchedulersIoToMainForCompletable())
    }
}