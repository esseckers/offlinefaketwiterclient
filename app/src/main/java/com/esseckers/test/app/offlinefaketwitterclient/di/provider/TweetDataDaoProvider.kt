package com.esseckers.test.app.offlinefaketwitterclient.di.provider

import com.esseckers.test.app.offlinefaketwitterclient.model.database.TweetDataDao
import com.esseckers.test.app.offlinefaketwitterclient.model.database.TweetsDatabase

/**
 * Created by Ivan Danilov.
 */
/**
 * TweetDataDaoProvider need for data access object(DAO) for table TweetData
 *
 * @param database need for provide dao
 */
class TweetDataDaoProvider constructor(private val database: TweetsDatabase) {
    /**
     * Return instance of TweetDataDao
     */
    fun get(): TweetDataDao = database.twitDataDao()
}