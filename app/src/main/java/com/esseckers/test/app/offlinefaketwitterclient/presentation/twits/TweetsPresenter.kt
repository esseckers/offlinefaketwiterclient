package com.esseckers.test.app.offlinefaketwitterclient.presentation.twits

import com.esseckers.test.app.offlinefaketwitterclient.R
import com.esseckers.test.app.offlinefaketwitterclient.entity.TweetData
import com.esseckers.test.app.offlinefaketwitterclient.model.interactor.twits.TweetsInteractor
import com.esseckers.test.app.offlinefaketwitterclient.presentation.base.BasePresenter
import io.reactivex.rxkotlin.subscribeBy

/**
 * Created by Ivan Danilov.
 */
class TweetsPresenter constructor(private val tweetsInteractor: TweetsInteractor) : BasePresenter<TweetsView>() {

    override fun onFirstAttach() {
        fetchData()
    }

    private fun fetchData() = execute(tweetsInteractor.getTweets())
        .subscribeBy(
            onSuccess = { viewState.showTweets(it) },
            onError = { viewState.showError(R.string.error) })


    fun logout() = execute(tweetsInteractor.logout().andThen(tweetsInteractor.deleteTweets()))
        .subscribeBy(
            onComplete = { viewState.logout() },
            onError = { viewState.showError(R.string.error) }
        )

    fun addNewOnePost(tweet: TweetData) = execute(tweetsInteractor.addPost(tweet))
        .subscribeBy(
            onComplete = { viewState.onNewOnePostAdded(tweet) },
            onError = { viewState.showError(R.string.error) })
}