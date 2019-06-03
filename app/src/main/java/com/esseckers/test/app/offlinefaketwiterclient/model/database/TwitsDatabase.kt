package com.esseckers.test.app.offlinefaketwiterclient.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.esseckers.test.app.offlinefaketwiterclient.entity.TwitData
import com.esseckers.test.app.offlinefaketwiterclient.entity.UserData

/**
 * Created by Ivan Danilov.
 */
@Database(entities = [TwitData::class, UserData::class], version = 1)
abstract class TwitsDatabase : RoomDatabase() {
    abstract fun twitDataDao(): TwitDataDao
    abstract fun userDataDao(): UserDataDao
}