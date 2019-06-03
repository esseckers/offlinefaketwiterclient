package com.esseckers.test.app.offlinefaketwiterclient.model

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Ivan Danilov.
 */
class AppSchedulers : SchedulersProvider {
    override fun ui() = AndroidSchedulers.mainThread()
    override fun io() = Schedulers.io()
}