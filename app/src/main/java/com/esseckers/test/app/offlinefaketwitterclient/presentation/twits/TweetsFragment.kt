package com.esseckers.test.app.offlinefaketwitterclient.presentation.twits

import androidx.recyclerview.widget.LinearLayoutManager
import com.esseckers.test.app.offlinefaketwitterclient.R
import com.esseckers.test.app.offlinefaketwitterclient.entity.TweetData
import com.esseckers.test.app.offlinefaketwitterclient.presentation.Screens
import com.esseckers.test.app.offlinefaketwitterclient.presentation.base.BaseFragment
import com.esseckers.test.app.offlinefaketwitterclient.presentation.generateNewOnePost
import kotlinx.android.synthetic.main.fragm_tweets.*
import org.koin.android.ext.android.inject

/**
 * Created by Ivan Danilov.
 */
class TweetsFragment : BaseFragment<TweetsView, TweetsPresenter>(), TweetsView {

    val tweetsPresenter: TweetsPresenter by inject()

    private var tweetsAdapter: TweetsAdapter? = null

    override val presenter: TweetsPresenter
        get() = tweetsPresenter

    override val layoutRes = R.layout.fragm_tweets

    override fun initView() {
        if (tweetsAdapter == null) {
            tweetsAdapter = TweetsAdapter()
        }
        rvTweets.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = tweetsAdapter
        }
        logoutImpl()

        addNewPostImpl()
    }

    private fun addNewPostImpl() {
        addNewPost.setOnClickListener {
            presenter.addNewOnePost(generateNewOnePost())
        }
    }

    private fun logoutImpl() {
        logout.setOnClickListener {
            presenter.logout()
        }
    }

    override fun logout() {
        appActivity.router.newRootScreen(Screens.SplashScreen)
    }

    override fun showTweets(tweets: List<TweetData>) {
        tweetsAdapter?.setData(tweets)
    }

    override fun onNewOnePostAdded(tweet: TweetData) {
        tweetsAdapter?.addItem(tweet)
        tweetsAdapter?.itemCount?.let {
            rvTweets.scrollToPosition(it - 1)
        }
    }
}