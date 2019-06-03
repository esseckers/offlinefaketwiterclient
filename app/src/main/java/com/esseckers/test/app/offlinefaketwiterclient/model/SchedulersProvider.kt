package com.esseckers.test.app.offlinefaketwiterclient.model

import io.reactivex.Scheduler

/**
 * Created by Ivan Danilov.
 */
interface SchedulersProvider {
    fun ui(): Scheduler
    fun io(): Scheduler
}