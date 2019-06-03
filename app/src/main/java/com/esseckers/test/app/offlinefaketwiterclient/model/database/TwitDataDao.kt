package com.esseckers.test.app.offlinefaketwiterclient.model.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.esseckers.test.app.offlinefaketwiterclient.entity.TwitData
import io.reactivex.Single


/**
 * Created by Ivan Danilov.
 */
@Dao
interface TwitDataDao {
    @Query("SELECT * from twitData")
    fun getTwits(): Single<List<TwitData>>

    @Insert(onConflict = REPLACE)
    fun insert(weatherData: TwitData): Single<Long>

    @Query("DELETE from twitData")
    fun deleteTwits(): Single<Void>
}