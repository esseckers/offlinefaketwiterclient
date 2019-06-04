package com.esseckers.test.app.offlinefaketwitterclient.model.interactor.twits

import com.esseckers.test.app.offlinefaketwitterclient.entity.TweetData
import com.esseckers.test.app.offlinefaketwitterclient.model.repository.twits.TweetsRepository
import com.esseckers.test.app.offlinefaketwitterclient.model.repository.user.UserRepository

/**
 * Created by Ivan Danilov.
 */
/**
 * TweetsInteractor need for fetch tweets, add new post
 * add delete user data and tweets if user logout
 *
 * @param tweetsRepository
 * @param userRepository
 */
class TweetsInteractor constructor(
    private val tweetsRepository: TweetsRepository,
    private val userRepository: UserRepository
) {
    /**
     * Obtain tweets from DB
     */
    fun getTweets() = tweetsRepository.getTweets()
    /**
     * Delete user when he logout from app
     */
    fun logout() = userRepository.deleteUser()
    /**
     * Save new one tweet to DB
     *
     * @param tweet
     */
    fun addPost(tweet: TweetData) = tweetsRepository.addNewOne(tweet)
    /**
     * Delete tweets data when he logout from app
     */
    fun deleteTweets() = tweetsRepository.deleteTweets()
}