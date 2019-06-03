package com.esseckers.test.app.offlinefaketwiterclient.di.provider

import com.esseckers.test.app.offlinefaketwiterclient.model.database.TwitDataDao
import com.esseckers.test.app.offlinefaketwiterclient.model.database.TwitsDatabase

/**
 * Created by Ivan Danilov.
 */
class TwitDataDaoProvider constructor(private val database: TwitsDatabase) {
    fun get(): TwitDataDao = database.twitDataDao()
}