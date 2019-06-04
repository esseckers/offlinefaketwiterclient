package com.esseckers.test.app.offlinefaketwitterclient.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.esseckers.test.app.offlinefaketwitterclient.entity.TweetData
import io.reactivex.Completable
import io.reactivex.Single


/**
 * Created by Ivan Danilov.
 */
/**
 * TweetDataDao for implement CRUD(CREATE,READ,UPDATE,DELETE)
 * operations with database on table TweetData
 */
@Dao
interface TweetDataDao {

    /**
     * Fetch tweets data from twitData table
     */
    @Query("SELECT * from twitData")
    fun getTwits(): Single<List<TweetData>>

    /**
     * Save to DB new tweets
     *
     * @param tweetData
     */
    @Insert(onConflict = REPLACE)
    fun insert(tweetData: List<TweetData>): Completable

    /**
     * Save to DB new tweet
     *
     * @param tweetData
     */
    @Insert(onConflict = REPLACE)
    fun insert(tweetData: TweetData): Completable

    /**
     * Delete from DB tweets when user logout
     */
    @Query("DELETE from twitData")
    fun deleteTwits(): Completable
}