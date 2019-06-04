package com.esseckers.test.app.offlinefaketwitterclient.model

import io.reactivex.CompletableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Ivan Danilov.
 */

/**
 * This function provide schedulers for Single
 * to make work in background thread and observe
 * result to main thread
 *
 * @return SingleTransformer
 */
fun <T> applySchedulersIoToMainForSingle(): SingleTransformer<T, T> {
    return SingleTransformer { single ->
        return@SingleTransformer single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

/**
 * This function provide schedulers for Completable
 * to make work in background thread and observe
 * result to main thread
 *
 * @return SingleTransformer
 */
fun applySchedulersIoToMainForCompletable(): CompletableTransformer {
    return CompletableTransformer { single ->
        return@CompletableTransformer single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}