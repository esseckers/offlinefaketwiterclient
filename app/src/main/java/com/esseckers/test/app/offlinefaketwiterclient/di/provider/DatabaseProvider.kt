package com.esseckers.test.app.offlinefaketwiterclient.di.provider

import android.arch.persistence.room.Room
import android.content.Context
import com.esseckers.test.app.offlinefaketwiterclient.model.database.TwitsDatabase

/**
 * Created by Ivan Danilov.
 */
class DatabaseProvider constructor(private val context: Context) {
    fun get(): TwitsDatabase = Room.databaseBuilder(context, TwitsDatabase::class.java, "twits_client.db").build()
}