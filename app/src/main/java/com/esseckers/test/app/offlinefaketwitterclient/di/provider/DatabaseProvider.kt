package com.esseckers.test.app.offlinefaketwitterclient.di.provider

import android.content.Context
import androidx.room.Room
import com.esseckers.test.app.offlinefaketwitterclient.model.database.TweetsDatabase

/**
 * Created by Ivan Danilov.
 */
/**
 * DatabaseProvider need for create database
 *
 * @param context need for provide database
 */
class DatabaseProvider constructor(private val context: Context) {
    /**
     * Return instance of database
     */
    fun get(): TweetsDatabase = Room.databaseBuilder(context, TweetsDatabase::class.java, "twits_client.db").build()
}