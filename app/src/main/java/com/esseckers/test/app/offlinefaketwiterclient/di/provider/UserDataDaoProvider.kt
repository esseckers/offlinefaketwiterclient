package com.esseckers.test.app.offlinefaketwiterclient.di.provider

import com.esseckers.test.app.offlinefaketwiterclient.model.database.TwitsDatabase
import com.esseckers.test.app.offlinefaketwiterclient.model.database.UserDataDao

/**
 * Created by Ivan Danilov.
 */
class UserDataDaoProvider constructor(private val database: TwitsDatabase) {
    fun get(): UserDataDao = database.userDataDao()
}