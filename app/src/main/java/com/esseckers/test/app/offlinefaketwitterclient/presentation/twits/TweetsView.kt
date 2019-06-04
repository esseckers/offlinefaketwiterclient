package com.esseckers.test.app.offlinefaketwitterclient.presentation.twits

import com.esseckers.test.app.offlinefaketwitterclient.entity.TweetData
import com.esseckers.test.app.offlinefaketwitterclient.presentation.base.BaseView

/**
 * Created by Ivan Danilov.
 */
interface TweetsView : BaseView {
    fun showTweets(tweets: List<TweetData>)
    fun logout()
    fun onNewOnePostAdded(tweet:TweetData)
}