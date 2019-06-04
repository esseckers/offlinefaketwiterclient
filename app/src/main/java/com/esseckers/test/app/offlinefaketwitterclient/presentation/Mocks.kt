package com.esseckers.test.app.offlinefaketwitterclient.presentation

import com.esseckers.test.app.offlinefaketwitterclient.R
import com.esseckers.test.app.offlinefaketwitterclient.entity.TweetData

/**
 * Created by Ivan Danilov.
 */

fun generateTwitsMocks(): List<TweetData> = List(20) { index ->
    TweetData(
        index.toLong(),
        R.drawable.ic_android_black_24dp,
        "Test user $index",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        R.drawable.img_lights
    )
}

fun generateNewOnePost(): TweetData = TweetData(
    null,
    R.drawable.ic_android_black_24dp,
    "Test user new ONE",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    R.drawable.img_lights
)