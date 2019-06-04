package com.esseckers.test.app.offlinefaketwitterclient.model.repository.twits

import com.esseckers.test.app.offlinefaketwitterclient.entity.TweetData
import com.esseckers.test.app.offlinefaketwitterclient.model.database.TweetDataDao
import com.esseckers.test.app.offlinefaketwitterclient.presentation.generateTwitsMocks

/**
 * Created by Ivan Danilov.
 */
/**
 * TweetsRepository need for save, read, delete tweets and
 * add new one to DB
 *
 * @param tweetDataDao
 */
class TweetsRepository constructor(private val tweetDataDao: TweetDataDao) {
    /**
     * Create tweets
     */
    fun createTweets() = tweetDataDao.insert(generateTwitsMocks())
    /**
     * Obtain tweets
     */
    fun getTweets() = tweetDataDao.getTwits()
    /**
     * Add new tweet
     *
     * @param tweet
     */
    fun addNewOne(tweet: TweetData) = tweetDataDao.insert(tweet)
    /**
     * Delete all tweets form DB
     */
    fun deleteTweets() = tweetDataDao.deleteTwits()
}