package com.esseckers.test.app.offlinefaketwitterclient.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.esseckers.test.app.offlinefaketwitterclient.entity.TweetData
import com.esseckers.test.app.offlinefaketwitterclient.entity.UserData

/**
 * Created by Ivan Danilov.
 */
/**
 * TweetsDatabase it's scheme of database
 */
@Database(entities = [TweetData::class, UserData::class], version = 1)
abstract class TweetsDatabase : RoomDatabase() {

    abstract fun twitDataDao(): TweetDataDao
    abstract fun userDataDao(): UserDataDao

}