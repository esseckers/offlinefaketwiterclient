package com.esseckers.test.app.offlinefaketwitterclient.model.interactor.splash

import com.esseckers.test.app.offlinefaketwitterclient.model.repository.twits.TweetsRepository
import com.esseckers.test.app.offlinefaketwitterclient.model.repository.user.UserRepository
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Ivan Danilov.
 */
/**
 * SplashInteractor need for check is user exists in database
 * and fill database fake data
 *
 * @param tweetsRepository
 * @param userRepository
 */
class SplashInteractor constructor(
    private val tweetsRepository: TweetsRepository,
    private val userRepository: UserRepository
) {
    /**
     * check is user exists in database
     */
    fun isUserLogged(): Single<Boolean> = userRepository
        .getUser()
        .flatMap {
            return@flatMap Single.just(it.isNotEmpty())
        }

    /**
     * fill database fake data
     */
    fun createTwits(): Completable = tweetsRepository.createTweets()
}