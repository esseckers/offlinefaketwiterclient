package com.esseckers.test.app.offlinefaketwitterclient.model.interactor.splash

import com.esseckers.test.app.offlinefaketwitterclient.entity.UserData
import com.esseckers.test.app.offlinefaketwitterclient.model.database.TweetDataDao
import com.esseckers.test.app.offlinefaketwitterclient.model.database.UserDataDao
import com.esseckers.test.app.offlinefaketwitterclient.model.repository.twits.TweetsRepository
import com.esseckers.test.app.offlinefaketwitterclient.model.repository.user.UserRepository
import com.esseckers.test.app.offlinefaketwitterclient.presentation.generateTwitsMocks
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by Ivan Danilov.
 */
class SplashInteractorTest {

    private lateinit var tweetsRepository: TweetsRepository
    private lateinit var userRepository: UserRepository
    private lateinit var tweetDao: TweetDataDao
    private lateinit var userDao: UserDataDao

    @Before
    fun setUp() {
        tweetDao = mock()
        userDao = mock()
        tweetsRepository = Mockito.spy(TweetsRepository(tweetDao))
        userRepository = Mockito.spy(UserRepository(userDao))
    }

    @Test
    fun isUserLogged_True() {

        whenever(userDao.getUsers()).thenReturn(Single.just(listOf(UserData(null, ""))))

        val interactor = SplashInteractor(tweetsRepository, userRepository)

        val testObserver = interactor.isUserLogged().test()
        testObserver.awaitTerminalEvent()

        verify(userRepository).getUser()

        testObserver
            .assertNoErrors()
            .assertValueCount(1)
            .assertResult(true)
    }

    @Test
    fun isUserLogged_False() {

        whenever(userDao.getUsers()).thenReturn(Single.just(emptyList()))

        val interactor = SplashInteractor(tweetsRepository, userRepository)

        val testObserver = interactor.isUserLogged().test()
        testObserver.awaitTerminalEvent()

        verify(userRepository).getUser()
        testObserver
            .assertNoErrors()
            .assertValueCount(1)
            .assertResult(false)
    }

    @Test
    fun createTwits_Created() {

        whenever(tweetDao.insert(generateTwitsMocks())).thenReturn(Completable.complete())

        val interactor = SplashInteractor(tweetsRepository, userRepository)

        val testObserver = interactor.createTwits().test()
        testObserver.awaitTerminalEvent()

        verify(tweetsRepository).createTweets()
        testObserver
            .assertNoErrors()
            .assertComplete()
    }
}