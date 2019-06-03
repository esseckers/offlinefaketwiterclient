package com.esseckers.test.app.offlinefaketwiterclient.model.repository.twits

import com.esseckers.test.app.offlinefaketwiterclient.model.SchedulersProvider
import com.esseckers.test.app.offlinefaketwiterclient.model.database.TwitDataDao

/**
 * Created by Ivan Danilov.
 */
class TwitsRepository constructor(
    private val twitDataDao: TwitDataDao,
    private val schedulers: SchedulersProvider
) {
    fun getTwits() = twitDataDao
        .getTwits()
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.ui())
}